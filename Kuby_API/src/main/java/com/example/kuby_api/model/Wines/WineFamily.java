package com.example.kuby_api.model.Wines;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "wine_family")
public class WineFamily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public WineFamily() {}

    public WineFamily(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}