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
    private Long stock_id;

    private LocalDateTime stock_date_in;

    private LocalDateTime stock_date_out;

    private int stock_quantity_in;

    private int stock_quantity_out;

    private int id_article;

}
