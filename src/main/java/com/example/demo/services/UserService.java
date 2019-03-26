package com.example.demo.services;

import com.example.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save_user(User user);

    List<User> findAllUsers();

    Optional<User> findUserById(int id);





}
