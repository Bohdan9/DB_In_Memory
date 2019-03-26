package com.example.demo.controllers;


import com.example.demo.models.Article;
import com.example.demo.models.Enums.Color;
import com.example.demo.models.User;
import com.example.demo.services.ServiceImpl.ArticleServiceImpl;
import com.example.demo.services.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleService;

    @Autowired
    UserServiceImpl userService;


    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public List<Article> findAllUsers(){
        return articleService.findAllArticles();
    }

    @RequestMapping(value = "/newArticle", method = RequestMethod.POST)
    public void addNewArticle() {
        Random random = new Random();
        Article article = new Article();
        User user = new User();
        Color color = Color.values()[(int) (Math.random() * Color.values().length)];
        StringBuilder builder = new StringBuilder();
        String alphabet = "abcdefghigklmnopqrstuvwxyz";
        for (int j = 0; j < 10; j++) {

            builder.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        String random_name = builder.toString();
        article.setText(random_name);
        article.setColor(color);
        //article.setUser(userService.findUserById(user.getId()).get());
        articleService.save_article(article);

    }



    }





