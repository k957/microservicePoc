package com.rest.stock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quotes")
public class Quote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String username;
	
	private String quotes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQuotes() {
		return quotes;
	}

	public void setQuotes(String quotes) {
		this.quotes = quotes;
	}

	public Quote(String username, String quotes) {
		super();
		
		this.username = username;
		this.quotes = quotes;
	}

	public Quote() {
		super();
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", username=" + username + ", quotes=" + quotes + "]";
	}
	
	
}
