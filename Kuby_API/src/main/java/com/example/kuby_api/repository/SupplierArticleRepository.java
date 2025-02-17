package com.example.kuby_api.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.kuby_api.model.SupplierArticle;
import java.util.List;

@Repository
public interface SupplierArticleRepository extends CrudRepository<SupplierArticle, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM SupplierArticle sa WHERE sa.id_article = :articleId")
    void deleteByArticleId(Long articleId);

    @Modifying
    @Transactional
    @Query("UPDATE SupplierArticle sa SET sa.id_user = :userId WHERE sa.id_article = :articleId")
    void updateUserForArticle(@Param("articleId") Long articleId, @Param("userId") Long userId);


    @Query("SELECT s FROM SupplierArticle s WHERE s.id_article = :articleId")
    List<SupplierArticle> findByArticleId(@Param("articleId") Long articleId);

    @Query("SELECT s FROM SupplierArticle s WHERE s.id_user = :userId")
    List<SupplierArticle> findByUserId(@Param("userId") Long userId);
}
