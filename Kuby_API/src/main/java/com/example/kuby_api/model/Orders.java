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
    @Column(name = "order_id") // Correspond à la colonne `order_id` dans la base de données
    private Long orderId; // Utilisez camelCase pour les noms de variables

    @Column(name = "order_date") // Correspond à la colonne `order_date` dans la base de données
    private LocalDateTime orderDate;

    @Column(name = "order_status") // Correspond à la colonne `order_status` dans la base de données
    private int orderStatus;

    @Column(name = "id_localisation") // Correspond à la colonne `id_localisation` dans la base de données
    private int idLocalisation;
}