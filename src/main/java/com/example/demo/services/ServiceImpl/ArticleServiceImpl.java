package com.example.demo.services.ServiceImpl;

import com.example.demo.models.Article;
import com.example.demo.reposetories.ArticleRepository;
import com.example.demo.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
   private ArticleRepository articleRepository;

    @Override
    public void save_article(Article article) {
        articleRepository.save(article);

    }

    @Override
    public List<Article> findAllArticles() {

        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> findArticlesById(int id) {
        return articleRepository.findById(id);
    }


}
