package com.example.kuby_api.model.Wines;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Wine")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long supplierId;
    private Long wineFamilyId;
    private Long variety;
    private Long terroir;
    private String name;
    private Integer stock;
    private String description;
}