package com.example.kuby_api.model;
import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "supplier_article")
public class SupplierArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplier_article_id;

    private int id_user;

    private int id_article;
}
