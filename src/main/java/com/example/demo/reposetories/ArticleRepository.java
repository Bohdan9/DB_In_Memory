package com.example.demo.reposetories;

import com.example.demo.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article,Integer> {
}
