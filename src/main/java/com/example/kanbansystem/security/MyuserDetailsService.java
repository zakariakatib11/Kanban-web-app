package com.example.kanbansystem.security;


import com.example.kanbansystem.Repository.UserRepository;
import com.example.kanbansystem.entities.User;
import org.apache.el.parser.AstTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class MyuserDetailsService implements UserDetailsService {

    @Autowired
   private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(App_user::new).get();
    }
    public User addNewUser(User user) {
        user.setRoles("ROLE_USER");
        user.setActive(true);
        User newUser = new User(
                user.getUsername(),
                passwordEncoder.encode(user.getPassword()),
                user.getEmail(),
                user.isActive(),
                user.getRoles());
        return userRepository.save(newUser);
    }
    public void deleteUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        user.ifPresent(userRepository::delete);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
