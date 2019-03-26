package com.example.demo.utils;

import com.example.demo.models.Article;
import com.example.demo.models.Enums.Color;
import com.example.demo.models.User;
import com.example.demo.reposetories.ArticleRepository;
import com.example.demo.services.ServiceImpl.ArticleServiceImpl;
import com.example.demo.services.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataInit implements ApplicationRunner {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ArticleServiceImpl articleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Random random = new Random();

        //Create users from 5 to 10
        int randon_numbOfusers =   random.nextInt(5) + 5;

        for (int i = 0; i <= randon_numbOfusers ; i++) {



            User user = new User();

            System.out.println(user);
            List<Article> articles = new ArrayList<>();

            StringBuilder sb = new StringBuilder();
            String alphabet = "abcdefghijklmnopqrstuvwxyz";

            //Create random name
            String[] name = {"Bodik", "Kate", "Leo", "John", "Merry","Lisa", "Chris", "Melania", "Emma", "Fred"};

            String random_names = name[random.nextInt(name.length)];
            user.setName(random_names);

            //Create random age
            int r_age = random.nextInt(50) + 10;
            user.setAge(r_age);


            //Create numbers of articles for users
            int numbersOfArticles = random.nextInt(10);
            for (int m = 0; m < numbersOfArticles; m++) {

                Article article = new Article();
                article.setUser(user);
                for (int n = 0; n < 20; n++) {
                    sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
                }
                String random_text = sb.toString();
                article.setText(random_text);

                //Choose random color from enum Color
                Color color = Color.values()[(int) (Math.random() * Color.values().length)];
                article.setColor(color);

                article.setText(random_text);

                articles.add(article);
                user.setArticles(articles);


                System.out.println(user);



                //Save users and articles in DB
            }

                userService.save_user(user);
                articleRepository.saveAll(articles);
        }


    }


}
