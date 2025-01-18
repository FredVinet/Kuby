package com.example.kuby_api.model.users;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long addressId;
    private String name;
    private String firstName;
    private String mail;
    private Integer phone;
}