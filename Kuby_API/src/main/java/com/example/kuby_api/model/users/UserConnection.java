package com.example.kuby_api.model.users;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UserConnection")
public class UserConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;
    private String password;
}
