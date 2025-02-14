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
            // Générer un token JWT
            String token = generateToken(user.get());

            // Retourner le token et les informations de l'utilisateur
            return ResponseEntity.ok(Map.of(
                    "user", user.get(), // Assurez-vous que l'objet User est bien renvoyé
                    "token", token      // Assurez-vous que le token est bien renvoyé
            ));
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Email ou mot de passe incorrect");
            return ResponseEntity.status(401).body(response);
        }
    }

    private String generateToken(User user) {
        // Définir la date d'expiration du token
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

        // Créer le token JWT
        return JWT.create()
                .withSubject(user.getUserMail()) // Sujet du token (généralement l'email ou l'ID de l'utilisateur)
                .withClaim("userId", user.getUser_id()) // Ajouter des claims personnalisés
                .withClaim("email", user.getUserMail())
                .withIssuedAt(new Date()) // Date de création du token
                .withExpiresAt(expirationDate) // Date d'expiration du token
                .sign(Algorithm.HMAC256(SECRET_KEY)); // Signer le token avec la clé secrète
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