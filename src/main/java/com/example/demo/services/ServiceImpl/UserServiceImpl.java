package com.example.demo.services.ServiceImpl;

import com.example.demo.models.User;
import com.example.demo.reposetories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public void save_user(User user) {
        userRepository.save(user);


    }
}
