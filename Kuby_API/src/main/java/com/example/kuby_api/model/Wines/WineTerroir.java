package com.example.kuby_api.model.Wines;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "WineTerroir")
public class WineTerroir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;

    public WineTerroir(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public WineTerroir() {

    }
}