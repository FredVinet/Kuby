package com.example.kuby_api.model;

import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "user_firstname")
    private String user_firstname;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_phone")
    private String user_phone;

    @Column(name = "user_mail")
    private String userMail;

    @Column(name = "user_password")
    private String user_password;

    @Column(name = "user_type")
    private int userType;
}