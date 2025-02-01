package com.example.kuby_api.controller;

import com.example.kuby_api.model.Article;
import com.example.kuby_api.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public Iterable<Article> getArticles() {
        return articleService.getArticles();
    }
}
