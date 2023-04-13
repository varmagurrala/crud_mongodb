package com.pro.product.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.product.model.Expense;
import com.pro.product.repository.ExpanceRepository;
import com.pro.product.service.ExpenseService;

@Service
public class EcpenseServiceImpl implements ExpenseService {

	private static final Optional<Expense> Expense = null;
	@Autowired
	private ExpanceRepository expanceRepository;
	
	@Override
	public Expense addExpense(Expense expense) {

		
		return expanceRepository.insert(expense);
	}

	@Override
	public List<Expense> getAllExpences() {
		return expanceRepository.findAll();
	}

	@Override
	public Expense updateExpance(Expense expense) {
		Optional<Expense> savedExpanse = Optional.ofNullable(expanceRepository.findById(expense.getId())
				.orElseThrow(() -> new RuntimeException(String.format("cannot find by id %s", expense.getId()))));
		Expense e= savedExpanse.get();
		e.setExpenseName(e.getExpenseName());
		e.setExpenseCategory(e.getExpenseCategory());
		e.setExpenseAmount(e.getExpenseAmount());
		
		expanceRepository.save(expense);
		
		return null;
	}

	@Override
	public Expense findbyName(String name) {
		
	

		return expanceRepository.findByName(name);
	}

	@Override
	public void deleteById(String id) {

		expanceRepository.deleteById(id);
	}

}
