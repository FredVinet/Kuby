package com.example.kuby_api.service;

import com.example.kuby_api.model.User;
import com.example.kuby_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.Data;


import java.util.List;
import java.util.Optional;


@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<User> getUser(final Long id){
        return userRepository.findById(id);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByType(int userType) {
        return userRepository.findByUserType(userType);
    }

    public void deleteUser(final Long id){
        userRepository.deleteById(id);
    }

    public Optional<User> findByuserMail(String userMail) {
        return userRepository.findByuserMail(userMail);
    }

    public String hashPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public User saveUser(User user) {
        user.setUser_password(passwordEncoder.encode(user.getUser_password()));
        return userRepository.save(user);
    }

    // Méthode pour vérifier le mot de passe
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}