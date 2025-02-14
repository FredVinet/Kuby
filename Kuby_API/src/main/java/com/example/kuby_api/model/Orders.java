package com.example.kuby_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long orders_id;

    @Column(name = "orders_date")
    private LocalDateTime orders_date;

    @Column(name = "orders_status")
    private String orders_status;

    @Column(name = "orders_amount")
    private float orders_amount;

    @Column(name = "id_localisation")
    private int id_localisation;
}