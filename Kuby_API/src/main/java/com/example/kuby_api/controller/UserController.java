package com.example.kuby_api.controller;

import com.example.kuby_api.model.Adress;
import com.example.kuby_api.model.Orders;
import com.example.kuby_api.model.User;
import com.example.kuby_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private static final String SECRET_KEY = "hello";
    private static final long EXPIRATION_TIME = 3600000;

    @GetMapping("/getAllUsers")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getOneUser/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getUsersByType/{type}")
    public List<User> getUsersByType(@PathVariable int type) {
        return userService.getUsersByType(type);
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setUser_id(id);
        return userService.saveUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{userId}/orders")
    public List<Orders> getOrdersByUserId(@PathVariable Integer userId) {
        return userService.getOrdersByUserId(userId);
    }

    @GetMapping("/{userId}/adresses")
    public List<Adress> getAdressesByUserId(@PathVariable Integer userId) {
        return userService.getAdressesByUserId(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String userMail = credentials.get("email");
        String password = credentials.get("password");

        Optional<User> user = userService.findByuserMail(userMail);

        if (user.isPresent() && userService.checkPassword(password, user.get().getUser_password())) {
            // Générer un token JWT avec le rôle "client"
            String token = generateToken(user.get(), "client");

            // Retourner le token et les informations de l'utilisateur
            return ResponseEntity.ok(Map.of(
                    "user", user.get(),
                    "token", token,
                    "role", "client"
            ));
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Email ou mot de passe incorrect");
            return ResponseEntity.status(401).body(response);
        }
    }

    @PostMapping("/loginAdmin")
    public ResponseEntity<?> loginAdmin(@RequestBody Map<String, String> credentials) {
        String userMail = credentials.get("email");
        String password = credentials.get("password");

        Optional<User> user = userService.findByuserMail(userMail);

        if (user.isPresent() && userService.checkPassword(password, user.get().getUser_password())) {
            // Vérifier si l'utilisateur est un admin (userType == 3)
            if (user.get().getUserType() == 3) {
                // Générer un token JWT avec le rôle "admin"
                String token = generateToken(user.get(), "admin");

                // Retourner le token et les informations de l'utilisateur
                return ResponseEntity.ok(Map.of(
                        "user", user.get(),
                        "token", token,
                        "role", "admin"
                ));
            } else {
                // L'utilisateur n'est pas un admin
                Map<String, String> response = new HashMap<>();
                response.put("message", "Accès refusé : vous n'êtes pas un administrateur");
                return ResponseEntity.status(403).body(response);
            }
        } else {
            // Email ou mot de passe incorrect
            Map<String, String> response = new HashMap<>();
            response.put("message", "Email ou mot de passe incorrect");
            return ResponseEntity.status(401).body(response);
        }
    }

    private String generateToken(User user, String role) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

        return JWT.create()
                .withSubject(user.getUserMail())
                .withClaim("userId", user.getUser_id())
                .withClaim("email", user.getUserMail())
                .withClaim("role", role) // Ajouter le rôle dans le token
                .withIssuedAt(new Date())
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }


    @PostMapping("/updatePassword/{id}")
    public ResponseEntity<?> updatePassword(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String newPassword = request.get("newPassword");

        try {
            userService.updatePassword(id, newPassword);
            return ResponseEntity.ok().body("Mot de passe mis à jour avec succès");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}