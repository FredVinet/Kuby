package com.example.kuby_api.model;
import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_id;

    private String article_name;

    private String article_description;

    private String article_grape;

    private int article_yearprod;

    private float article_price;

    private int id_family;

    private int id_grape;
}
