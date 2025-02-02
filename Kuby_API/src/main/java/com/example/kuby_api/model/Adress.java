package com.example.kuby_api.model;
import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adress_id;

    private int adress_number;

    private String adress_country;

    private String adress_state;

    private String adress_name;

    private String adress_city;

    private String adress_code;
}