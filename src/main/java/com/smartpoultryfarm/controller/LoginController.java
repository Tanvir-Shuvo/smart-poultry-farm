package com.smartpoultryfarm.controller;

import com.smartpoultryfarm.entity.User;
import com.smartpoultryfarm.service.LoginService;
import com.smartpoultryfarm.gamification.service.GamificationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private GamificationService gamificationService;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session
    ){

        User user = loginService.loginUser(email, password);

        if(user != null){

            session.setAttribute("loggedUser", user);

            gamificationService.addLoginXP(user);

            return "redirect:/dashboard";
        }

        return "login";
    }
}