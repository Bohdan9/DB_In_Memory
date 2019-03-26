package com.example.demo.services;

import com.example.demo.models.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {


    void save_article(Article article);

    List<Article> findAllArticles();

    Optional<Article> findArticlesById(int id);


}
