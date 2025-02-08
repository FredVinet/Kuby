package com.example.kuby_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.kuby_api.model.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByuserMail(String userMail); // Modifié ici
    List<User> findByUserType(int userType);
}