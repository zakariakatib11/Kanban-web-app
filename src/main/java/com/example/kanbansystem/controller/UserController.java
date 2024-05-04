package com.example.kanbansystem.controller;

import com.example.kanbansystem.entities.User;
import com.example.kanbansystem.security.MyuserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private MyuserDetailsService myuserDetailsService;
    @PostMapping("/user")
    public String addUser(@RequestBody User user){
        myuserDetailsService.addNewUser(user);
        return "User added successfully!";
    }
    @DeleteMapping("/user/{username}")
    public ResponseEntity<String> deleteUserByUsername(@PathVariable String username) {
        myuserDetailsService.deleteUserByUsername(username);
        return ResponseEntity.ok("User deleted successfully!");
    }
    @GetMapping("/Allusers")
    public List<User> getAllUsers() {
        return myuserDetailsService.getAllUsers();
    }
}
