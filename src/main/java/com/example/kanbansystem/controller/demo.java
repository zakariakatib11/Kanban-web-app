package com.example.kanbansystem.controller;

import com.example.kanbansystem.entities.Board;
import com.example.kanbansystem.entities.Task;
import com.example.kanbansystem.entities.user;
import com.example.kanbansystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class demo {

    Board bord = new Board();
    user savedUser = new user("user", "123", "admin", true, "ROLE_USER");


    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String hello(){
        return "hello";

    }
    @GetMapping("/admin")
    public String helloAdmin(){
        return "hello admin";
    }
    @GetMapping("/user")
    public String helloUser(){
        return "hello user";
    }

    @PostMapping("/addUser")
    public String addUser() {
        System.out.println("test1");
        userService.saveuser(savedUser);
        System.out.println("test2");
        return "User added successfully!";
    }


}
