package com.example.kuby_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.kuby_api.model.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

}

