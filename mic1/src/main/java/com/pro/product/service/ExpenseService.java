package com.pro.product.service;

import java.util.List;

import com.pro.product.model.Expense;

public interface ExpenseService {
	
	Expense addExpense(Expense expense);
	
	List<Expense> getAllExpences();
	
	Expense updateExpance(Expense expense);

	Expense findbyName(String name);
	
	void deleteById(String name);
}
