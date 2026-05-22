package com.smartpoultryfarm.service;

import com.smartpoultryfarm.entity.ExpenseEntity;
import com.smartpoultryfarm.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // save expense
    public void saveExpense(ExpenseEntity expense){

        expenseRepository.save(expense);

    }
}