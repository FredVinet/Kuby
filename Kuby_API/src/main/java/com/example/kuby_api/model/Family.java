package com.example.kuby_api.model;
import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "family")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long family_id;

    private String family_name;

    private String family_description;

}
