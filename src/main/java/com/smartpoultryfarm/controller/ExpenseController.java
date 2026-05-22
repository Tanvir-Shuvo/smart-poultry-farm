package com.smartpoultryfarm.controller;

import com.smartpoultryfarm.entity.ExpenseEntity;
import com.smartpoultryfarm.entity.User;
import com.smartpoultryfarm.service.ExpenseService;
import com.smartpoultryfarm.gamification.service.GamificationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private GamificationService gamificationService;

    @GetMapping("/expense")
    public String expensePage(){
        return "expense";
    }

    @PostMapping("/saveExpense")
    public String saveExpense(
            @ModelAttribute ExpenseEntity expense,
            HttpSession session
    ){

        User user =
                (User) session.getAttribute("loggedUser");

        if(user == null){
            return "redirect:/login";
        }

        // attach user
        expense.setUser(user);

        // save expense
        expenseService.saveExpense(expense);

        // XP add
        gamificationService.addXP(user);

        return "redirect:/dashboard";
    }
}