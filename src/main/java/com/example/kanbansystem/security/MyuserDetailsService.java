package com.example.kanbansystem.security;


import com.example.kanbansystem.Repository.UserRepository;
import com.example.kanbansystem.entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public class MyuserDetailsService implements UserDetailsService {

    @Autowired
   private UserRepository UserRepository;
    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<user> user = UserRepository.findByUsername(username);
        return user.map(App_user::new).get();
    }




}
