package com.pro.product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.product.model.Expense;
import com.pro.product.service.ExpenseService;

import lombok.Delegate;

@RestController
@RequestMapping("/api/expanse")
public class ExpanseControoler {
	
	@Autowired
	private ExpenseService expenseService;
	
	@PostMapping
	public ResponseEntity<Expense> addExpense(@RequestBody Expense expense){
		return new ResponseEntity<>(expenseService.addExpense(expense),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpences(){
		return new ResponseEntity<>(expenseService.getAllExpences(),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Expense> updateExpance(@RequestBody Expense expense){
		
		return new ResponseEntity<>(expenseService.updateExpance(expense),HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Expense> getByName(@PathVariable String name ){
		
		return new ResponseEntity<>(expenseService.findbyName(name),HttpStatus.OK);
	}
	
	@DeleteMapping("/{name}")
	public ResponseEntity<String> deleteByName(@PathVariable String name ){
		
		return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
