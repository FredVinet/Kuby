package com.example.kuby_api.controller;

import com.example.kuby_api.model.User;
import com.example.kuby_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getOneUser/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUser(id);
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String userMail = credentials.get("email");
        String password = credentials.get("password");

        Optional<User> user = userService.findByuserMail(userMail);

        if (user.isPresent() && userService.checkPassword(password, user.get().getUser_password())) {
            return ResponseEntity.ok(user.get());
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Email ou mot de passe incorrect");
            return ResponseEntity.status(401).body(response);
        }
    }

    @PostMapping("/updatePassword/{id}")
    public ResponseEntity<?> updatePassword(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String newPassword = request.get("newPassword");

        Optional<User> userOptional = userService.getUser(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUser_password(userService.hashPassword(newPassword)); // Hacher le nouveau mot de passe
            userService.saveUser(user);
            return ResponseEntity.ok().body("Mot de passe mis à jour avec succès");
        } else {
            return ResponseEntity.status(404).body("Utilisateur non trouvé");
        }
    }
}