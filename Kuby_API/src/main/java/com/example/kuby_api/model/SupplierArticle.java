package com.example.kuby_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "supplier_article")
@JsonIgnoreProperties({"article"})
public class SupplierArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_article_id")
    private Long supplier_article_id;

    @ManyToOne
    @JoinColumn(name = "id_article", referencedColumnName = "article_id", nullable = false)
    private Article article;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "user_id", nullable = false)
    private User supplier;
}
