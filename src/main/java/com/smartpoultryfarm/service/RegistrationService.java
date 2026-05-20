package com.smartpoultryfarm.service;


import com.smartpoultryfarm.entity.User;
import com.smartpoultryfarm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user){
        userRepository.save(user);
    }
}
