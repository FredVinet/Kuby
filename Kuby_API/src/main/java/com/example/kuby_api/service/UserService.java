package com.example.kuby_api.service;

import com.example.kuby_api.model.Adress;
import com.example.kuby_api.model.Orders;
import com.example.kuby_api.model.User;
import com.example.kuby_api.repository.AdressRepository;
import com.example.kuby_api.repository.OrdersRepository;
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
    private OrdersRepository ordersRepository;

    @Autowired
    private AdressRepository adressRepository;

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

    public void updatePassword(Long userId, String newPassword) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUser_password(hashPassword(newPassword));
            userRepository.save(user);
        } else {
            throw new RuntimeException("Utilisateur non trouvé");
        }
    }

    public List<Orders> getOrdersByUserId(Integer userId) {
        return ordersRepository.findByUserId(userId);
    }

    public List<Adress> getAdressesByUserId(Integer userId) {
        return adressRepository.findByUserId(userId);
    }
}