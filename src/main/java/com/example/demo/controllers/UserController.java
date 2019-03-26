package com.example.demo.controllers;


import com.example.demo.models.Article;
import com.example.demo.models.Enums.Color;
import com.example.demo.models.User;
import com.example.demo.services.ServiceImpl.ArticleServiceImpl;
import com.example.demo.services.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ArticleServiceImpl articleService;





    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }


    @RequestMapping(value = "/graterthen", method = RequestMethod.GET)
    public List<User> findUsersWithAgeGraterThen(@RequestParam int age){
        return userService.findAllUsers()
                .stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }


    @RequestMapping(value = "/colors", method = RequestMethod.GET)
    public List<User> findUsersByColor(@RequestParam String color, @RequestBody Color color_value){
        color_value.valueOf(color);
        return userService.findAllUsers()
                .stream()
                .filter(user -> user.getArticles()
                .stream()
                .anyMatch(article -> article.getColor()==(color_value)))
                .collect(Collectors.toList());

    }

   /* @RequestMapping(value = "/uniqueName", method = RequestMethod.GET)
    public List<User> findUsersWhereArticleMoreThen3(){

        return userService.findAllUsers()
                .stream()
                .filter(user -> user.getArticles().size() > 3 )
                .filter()
                .collect(Collectors.toList());
    }*/

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public void addNewUser() {
        User user = new User();
        Random random = new Random();
        int random_age = random.nextInt(40) + 18;


        String[] name = {"Bodik", "Kate", "Leo", "John", "Merry","Lisa", "Chris", "Melania", "Emma", "Fred"};
        String random_names = name[random.nextInt(name.length)];
        user.setName(random_names);
        user.setAge(random_age);
        userService.save_user(user);

    }


    @RequestMapping(value = "/united", method = RequestMethod.GET)
    public Map<User, List<Article>> UsersAndArticles() {
        Map<User, List<Article>> CombineMap = new TreeMap<>();
        List<User> users = userService.findAllUsers();

        for (User u : users
        ) {
            CombineMap.put(u, u.getArticles());
        }
        return CombineMap;
    }










}
