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

    @Column(name = "article_grape")
    private String article_grape;

    @Column(name = "article_yearprod")
    private int article_yearprod;

    @Column(name = "article_price")
    private float article_price;

    @Column(name = "id_family")
    private int id_family;

    @Column(name = "id_grape")
    private int id_grape;
}