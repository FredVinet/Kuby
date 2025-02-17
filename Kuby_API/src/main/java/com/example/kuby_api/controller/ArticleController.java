package com.example.kuby_api.controller;

import com.example.kuby_api.model.Article;
import com.example.kuby_api.model.SupplierArticle;
import com.example.kuby_api.service.ArticleService;
import com.example.kuby_api.service.SupplierArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // Injection du service SupplierArticleService
    @Autowired
    private SupplierArticleService supplierArticleService;

    @GetMapping("/getAllArticles")
    public Iterable<Article> getArticles() {
        return articleService.getArticles();
    }

    @GetMapping("/getAllArticlesDetails")
    public List<Map<String, Object>> getAllArticlesWithDetails() {
        return articleService.getAllArticlesWithDetails();
    }

    @GetMapping("/getOneArticle/{id}")
    public Optional<Article> getArticleById(@PathVariable Long id) {
        return articleService.getArticle(id);
    }

    @PostMapping("/createArticle/{userId}")
    public ResponseEntity<Map<String, Object>> createArticle(@PathVariable Long userId, @RequestBody Article article) {

        Article savedArticle = articleService.createArticle(article);

        SupplierArticle supplierArticle = new SupplierArticle();
        supplierArticle.setId_article(savedArticle.getArticle_id());
        supplierArticle.setId_user(userId);

        SupplierArticle savedSupplierArticle = supplierArticleService.saveSupplierArticle(supplierArticle);

        Map<String, Object> response = new HashMap<>();
        response.put("article", savedArticle);
        response.put("supplier_article", savedSupplierArticle);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateArticle/{id}")
    public Article updateArticle(@PathVariable Long id,
                                 @RequestBody Article article,
                                 @RequestParam Long userId) {
        return articleService.updateArticle(id, article, userId);
    }



    @DeleteMapping("/deleteArticle/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
