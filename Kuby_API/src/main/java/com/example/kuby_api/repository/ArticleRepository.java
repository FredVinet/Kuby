package com.example.kuby_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kuby_api.model.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

    @Query("SELECT a.article_id, a.article_name, a.article_description, " +
            "a.article_yearprod, a.article_price, a.article_quantity_in, " +
            "a.article_quantity_out, a.id_family, a.id_grape, " +
            "f.family_name, g.grape_name, sa.id_user, u.user_firstname, u.user_name " +
            "FROM Article a " +
            "JOIN Family f ON a.id_family = f.family_id " +
            "JOIN Grape g ON a.id_grape = g.grape_id " +
            "JOIN SupplierArticle sa ON a.article_id = sa.id_article " +
            "JOIN User u ON sa.id_user = u.user_id")
    List<Object[]> findAllArticlesWithDetails();

    @Query("SELECT a FROM Article a WHERE a.id_family = :idFamily")
    List<Article> findByFamilyId(@Param("idFamily") Long idFamily);

    @Query("SELECT a FROM Article a WHERE a.id_grape = :idGrape")
    List<Article> findByGrapeId(@Param("idGrape") Long idGrape);
}
