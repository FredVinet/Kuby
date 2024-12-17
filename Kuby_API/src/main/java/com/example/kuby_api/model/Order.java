package com.example.kuby_api.model;
import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    private LocalDateTime order_date;

    private int order_status;

    private int id_localisation;

}
