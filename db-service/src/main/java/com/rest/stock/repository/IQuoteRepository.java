package com.rest.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.stock.model.Quote;

public interface IQuoteRepository extends JpaRepository<Quote, Integer>{
	
	List<Quote> findByUsername(String username);
}
