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
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "wineFamilyId")
    private WineFamily wineFamily;

    @ManyToOne
    @JoinColumn(name = "variety")
    private WineVariety variety;

    @ManyToOne
    @JoinColumn(name = "terroir")
    private WineTerroir terroir;

    private String name;
    private Long stock;
    private String description;
}