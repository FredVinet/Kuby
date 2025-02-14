package com.example.kuby_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long article_id;

    @Column(name = "article_name")
    private String article_name;

    @Column(name = "article_description")
    private String article_description;

    @Column(name = "article_yearprod")
    private int article_yearprod;

    @Column(name = "article_price")
    private float article_price;

    @Column(name = "article_quantity_in")
    private int article_quantity_in;

    @Column(name = "article_quantity_out")
    private int article_quantity_out;

    @Column(name = "id_family", nullable = false)
    private Long id_family;

    @Column(name = "id_grape", nullable = false)
    private Long id_grape;
}
