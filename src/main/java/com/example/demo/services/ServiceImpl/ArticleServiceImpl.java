package com.example.demo.services.ServiceImpl;

import com.example.demo.models.Article;
import com.example.demo.reposetories.ArticleRepository;
import com.example.demo.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void save_article(Article article) {
        articleRepository.save(article);

    }



}
