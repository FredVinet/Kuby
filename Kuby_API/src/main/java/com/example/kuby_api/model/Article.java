package com.example.kuby_api.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "article")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    // Relation avec Family
    @ManyToOne
    @JoinColumn(name = "id_family", referencedColumnName = "family_id", nullable = false)
    @JsonManagedReference
    private Family family;

    // Relation avec Grape
    @ManyToOne
    @JoinColumn(name = "id_grape", referencedColumnName = "grape_id", nullable = false)
    @JsonManagedReference
    private Grape grape;

    @OneToOne(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SupplierArticle supplierArticle;


}