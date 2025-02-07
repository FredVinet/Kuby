package com.example.kuby_api.model;
import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long stock_id;

    @Column(name = "stock_date_in")
    private LocalDateTime stock_date_in;

    @Column(name = "stock_date_out")
    private LocalDateTime stock_date_out;

    @Column(name = "stock_quantity_in")
    private int stock_quantity_in;

    @Column(name = "stock_quantity_out")
    private int stock_quantity_out;

    @Column(name = "id_article")
    private int id_article;

}