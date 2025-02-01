package com.example.kuby_api.model.Wines;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "WineVariety")
public class WineVariety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public WineVariety(Object o, String rouge) {
    }

    public WineVariety() {

    }
}