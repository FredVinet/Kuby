package com.example.kuby_api.model;
import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "grape")
public class Grape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grape_id")
    private Long grape_id;

    @Column(name = "grape_name")
    private String grape_name;

    @Column(name = "grape_description")
    private String grape_description;
}