package com.example.kanbansystem.service;

import com.example.kanbansystem.Repository.UserRepository;
import com.example.kanbansystem.entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public user saveuser(user userDto) {
        user new_user=new user(userDto.getUsername(),userDto.getPassword(),
                userDto.getEmail(),userDto.isActive(),userDto.getRoles());

        return userRepository.save(new_user);
    }
}
