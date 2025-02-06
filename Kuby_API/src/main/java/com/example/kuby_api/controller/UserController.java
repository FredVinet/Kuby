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
        String email = credentials.get("user_mail");
        String password = credentials.get("user_password");

        Optional<User> user = userService.findByUserMail(email);

        if (user.isPresent() && userService.checkPassword(password, user.get().getUser_password())) {
            return ResponseEntity.ok(user.get());
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Email ou mot de passe incorrect");
            return ResponseEntity.status(401).body(response);
        }
    }
}