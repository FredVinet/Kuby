package com.example.kuby_api.model.Wines;

import com.example.kuby_api.model.users.Supplier;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Wine")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private WineFamily wineFamily;

    @ManyToOne
    private WineVariety variety;

    @ManyToOne
    private WineTerroir terroir;

    private String name;
    private Long stock;
    private String description;
}