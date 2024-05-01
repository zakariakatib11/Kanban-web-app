package com.example.kanbansystem.controller;

import com.example.kanbansystem.entities.User;
import com.example.kanbansystem.security.MyuserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private MyuserDetailsService myuserDetailsService;
    @PostMapping("/user")
    public String addUser(@RequestBody User user){
        myuserDetailsService.addNewUser(user);
        return "User added successfully!";
    }
}
