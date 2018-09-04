package com.rest.stock.dto;

import java.util.List;

public class QuoteDto {
	
	private String username;
	
	private List<String> quotes;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
	
	
}
