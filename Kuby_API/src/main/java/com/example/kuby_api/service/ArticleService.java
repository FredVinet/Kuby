package com.example.kuby_api.service;

import com.example.kuby_api.model.Article;
import com.example.kuby_api.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Supplier;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private SupplierArticleService supplierArticleService;

    public List<Map<String, Object>> getAllArticlesWithDetails() {
        List<Object[]> results = articleRepository.findAllArticlesWithDetails();
        List<Map<String, Object>> articlesWithDetails = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> articleData = new HashMap<>();
            articleData.put("article_id", row[0]);
            articleData.put("article_name", row[1]);
            articleData.put("article_description", row[2]);
            articleData.put("article_yearprod", row[3]);
            articleData.put("article_price", row[4]);
            articleData.put("article_quantity_in", row[5]);
            articleData.put("article_quantity_out", row[6]);
            articleData.put("id_family", row[7]);
            articleData.put("id_grape", row[8]);
            articleData.put("family_name", row[9]);
            articleData.put("grape_name", row[10]);
            articleData.put("user_id", row[11]);
            articleData.put("user_name", row[13]);

            articlesWithDetails.add(articleData);
        }
        return articlesWithDetails;
    }


        for (Object[] row : results) {
            Map<String, Object> articleData = new HashMap<>();
            articleData.put("article_id", row[0]);
            articleData.put("article_name", row[1]);
            articleData.put("article_description", row[2]);
            articleData.put("article_yearprod", row[3]);
            articleData.put("article_price", row[4]);
            articleData.put("article_quantity_in", row[5]);
            articleData.put("article_quantity_out", row[6]);
            articleData.put("id_family", row[7]);
            articleData.put("id_grape", row[8]);
            articleData.put("family_name", row[9]);
            articleData.put("grape_name", row[10]);
            articleData.put("user_id", row[11]);
            articleData.put("user_name", row[13]);

            articlesWithDetails.add(articleData);
        }
        return articlesWithDetails;
    }

    public Optional<Article> getArticle(final Long id) {
        return articleRepository.findById(id);
    }

    public Iterable<Article> getArticles() {
        return articleRepository.findAll();
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article article, Long userId) {
        article.setArticle_id(id);
        supplierArticleService.updateSupplierArticleUser(id, userId);
        return articleRepository.save(article);
    }

    public void deleteArticle(final Long id) {
        supplierArticleService.deleteSupplierArticlesByArticleId(id);
        articleRepository.deleteById(id);
    }

    public List<Article> getArticlesByFamilyId(Long idFamily) {
        return articleRepository.findByFamilyId(idFamily);
    }

    public List<Article> getArticlesByGrapeId(Long idGrape) {
        return articleRepository.findByGrapeId(idGrape);
    }

    @Transactional
    public void decreaseArticleQuantity(Long articleId, int quantityOrdered) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article non trouvé"));

        if (article.getArticle_quantity_in() < quantityOrdered) {
            throw new RuntimeException("Stock insuffisant pour l'article " + article.getArticle_name());
        }

        article.setArticle_quantity_in(article.getArticle_quantity_in() - quantityOrdered);
        articleRepository.save(article);
    }
}
