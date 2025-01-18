package com.example.kuby_api.model.Wines;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "WineFamily")
public class WineFamily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}