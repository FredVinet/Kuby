package com.example.kuby_api.model.users;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstName;
    private Integer phone;
    private String mail;
    private String password;

    @OneToMany
    private List<Address> addressList;
}