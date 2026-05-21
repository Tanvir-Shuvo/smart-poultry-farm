package com.smartpoultryfarm.controller;

import com.smartpoultryfarm.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        // session থেকে user নেওয়া
        User user = (User) session.getAttribute("loggedUser");

        // login না থাকলে login page
        if(user == null){
            return "redirect:/login";
        }

        // html এ user পাঠানো
        model.addAttribute("user", user);

        return "dashboard";
    }
}