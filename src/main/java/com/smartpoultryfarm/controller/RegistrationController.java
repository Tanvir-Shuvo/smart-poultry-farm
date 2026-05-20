package com.smartpoultryfarm.controller;


import com.smartpoultryfarm.entity.User;
import com.smartpoultryfarm.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @GetMapping("/registration") // page display
    public String registrationPage() {
        return ("registration");
    }

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registration") // form submit handle
    public String registrationUser(User user) {
        registrationService.registerUser(user);
        return "redirect:/login";
    }
}
