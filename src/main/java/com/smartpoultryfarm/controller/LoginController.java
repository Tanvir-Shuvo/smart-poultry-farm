package com.smartpoultryfarm.controller;

import com.smartpoultryfarm.entity.User;
import com.smartpoultryfarm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // show login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // process login
    @PostMapping("/login")
    public String processLogin(@RequestParam String email,
                               @RequestParam String password,
                               Model model) {

        User user = loginService.loginUser(email, password);

        if (user != null) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}