package com.example.kuby_api.model;
import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adress_id")
    private Integer adress_id;

    @Column(name = "adress_number")
    private int adress_number;

    @Column(name = "adress_country")
    private String adress_country;

    @Column(name = "adress_state")
    private String adress_state;

    @Column(name = "adress_name")
    private String adress_name;

    @Column(name = "adress_city")
    private String adress_city;

    @Column(name = "adress_code")
    private String adress_code;
}