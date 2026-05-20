package com.smartpoultryfarm.service;

import com.smartpoultryfarm.entity.User;
import com.smartpoultryfarm.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public User loginUser(String email, String password){

        User user = userRepository.findByEmail(email);

        if(user != null && user.getPassword().equals(password)){
            return user;   // login success
        }

        return null;      // login fail
    }
}