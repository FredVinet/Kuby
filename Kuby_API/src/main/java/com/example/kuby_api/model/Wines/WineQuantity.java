package com.example.kuby_api.model.Wines;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name  = "WineQuantity")
public class WineQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Wine wine;
    private long quantity;


}
