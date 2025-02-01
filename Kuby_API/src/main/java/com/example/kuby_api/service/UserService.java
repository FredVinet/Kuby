package com.example.kuby_api.service;

import com.example.kuby_api.model.User;
import com.example.kuby_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;


import java.util.Optional;


@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(final Long id){
        return userRepository.findById(id);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(final Long id){
        userRepository.deleteById(id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
