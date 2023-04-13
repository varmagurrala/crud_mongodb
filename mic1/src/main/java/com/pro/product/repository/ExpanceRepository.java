package com.pro.product.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pro.product.model.Expense;

public interface ExpanceRepository extends MongoRepository<Expense, String> {

	@Query("{'name': ?0}")
	Expense findByName(String name);
}
