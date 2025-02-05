package com.example.kuby_api.model;
import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "family")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "family_id")
    private Long family_id;

    @Column(name = "family_name")
    private String family_name;

    @Column(name = "family_description")
    private String family_description;

}