package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.ServiceImpl.UserServiceImpl;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @Mock
    private UserServiceImpl userService;



    @InjectMocks
    UserController userController;


    @Test
    public void findAllUsers() throws Exception {

        Mockito.when(userService.findAllUsers()).thenReturn(ImmutableList.of());

        List<User> userList = userController.findAllUsers();


        verify(userService).findAllUsers();

    }

}