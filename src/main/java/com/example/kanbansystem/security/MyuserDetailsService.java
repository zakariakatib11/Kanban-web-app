package com.example.kanbansystem.security;


import com.example.kanbansystem.Repository.UserRepository;
import com.example.kanbansystem.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class MyuserDetailsService implements UserDetailsService {

    @Autowired
   private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(App_user::new).get();
    }
    public User addNewUser(User userDto) {
        User new_user=new User(userDto.getUsername(),userDto.getPassword(),
                userDto.getEmail(),userDto.isActive(),userDto.getRoles());
        return userRepository.save(new_user);
    }




}
