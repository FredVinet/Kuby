package com.example.kuby_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "supplier_article")
public class SupplierArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_article_id")
    private Long supplier_article_id;

    @Column(name = "id_article")
    private Long id_article;  // Stocke l'ID de l'article

    @Column(name = "id_user")
    private Long id_user;  // Stocke l'ID du fournisseur
}
