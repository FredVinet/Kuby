package com.example.kuby_api.model;
import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_items_id")
    private Long order_items_id;

    @Column(name = "id_order")
    private int id_order;

    @Column(name = "id_article")
    private long id_article;

    @Column(name = "order_items_quantity")
    private int order_items_quantity;

    @Column(name = "unit_price")
    private int unit_price;
}