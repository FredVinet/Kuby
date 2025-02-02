package com.example.kuby_api.model;
import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "`orders`")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orders_id;

    private LocalDateTime orders_date;

    private int orders_status;

    private int id_localisation;

}