package com.example.kuby_api.model.Wines;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "WineVariety")
public class WineVariety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}