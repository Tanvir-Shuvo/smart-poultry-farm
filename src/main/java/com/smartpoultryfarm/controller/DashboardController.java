package com.smartpoultryfarm.controller;

import com.smartpoultryfarm.entity.User;
import com.smartpoultryfarm.gamification.service.GamificationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private GamificationService gamificationService;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){

        User user =
                (User) session.getAttribute("loggedUser");

        if(user == null){
            return "redirect:/login";
        }

        Integer xp = gamificationService.getXP(user);

        model.addAttribute("user", user);
        model.addAttribute("xp", xp);

        return "dashboard";
    }
}