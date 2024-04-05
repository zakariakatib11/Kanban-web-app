package com.example.kanbansystem.controller;

import com.example.kanbansystem.entities.User;
import com.example.kanbansystem.security.MyuserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class demo {
    @Autowired
    private MyuserDetailsService myuserDetailsService;
    @GetMapping("/hello")
    public String hello(){return "hello";}
    @GetMapping("/admin")
    public String helloAdmin(){
        return "hello admin";
    }
    @GetMapping("/user")
    public String helloUser(){
        return "hello User";
    }
    @PostMapping("/addUser")
    public String addUser(){
        User savedUser = new User();
        myuserDetailsService.addNewUser(savedUser);
        return "User added successfully!";
    }


}
