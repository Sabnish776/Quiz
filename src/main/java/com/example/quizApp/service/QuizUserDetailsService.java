package com.example.quizApp.service;

import com.example.quizApp.model.Users;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class QuizUserDetailsService implements UserDetailsService {

    private final Map<String, Users> users = new HashMap<>();
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    {
        users.put("sabu",new Users("sabu","sabnish1776@gmail.com",passwordEncoder.encode("sabu") , "ADMIN")) ;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = users.get(username) ;
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
    // Registers Users
    public void registerUsers(String username,String email,String password , String role) throws Exception {
        if(users.containsKey(username)){
            System.out.println("User already exists");
            throw new Exception("User already exists");
        }
        users.put(username , new Users(username,email,passwordEncoder.encode(password),role));
        System.out.println("User registered successfully: " + username);
    }
}
