package com.example.kuby_api.model;

import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String user_firstname;

    private String user_name;

    private String user_phone;

    private String user_mail;

    private String user_password;

    private int user_type;

    private boolean user_admin;

}
