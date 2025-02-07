package com.example.kuby_api.model;
import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "localisation")
public class Localisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "localisation_id")
    private Long localisation_id;

    @Column(name = "id_user")
    private int id_user;

    @Column(name = "id_adress")
    private int id_adress;

}