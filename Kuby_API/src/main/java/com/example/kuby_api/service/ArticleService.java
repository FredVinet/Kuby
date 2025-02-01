package com.example.kuby_api.service;

import com.example.kuby_api.model.Article;
import com.example.kuby_api.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import java.util.Optional;

@Data
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Optional<Article> getArticle(final Long id){
        return articleRepository.findById(id);
    }

    public Iterable<Article> getArticles() {
        return articleRepository.findAll();
    }

    public void deleteArticle(final Long id){
        articleRepository.deleteById(id);
    }

    public Article saveArticle(Article article){
        return articleRepository.save(article);
    }
}

