package com.rest.stock.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.stock.dto.QuoteDto;
import com.rest.stock.model.Quote;
import com.rest.stock.repository.IQuoteRepository;

@RestController
@RequestMapping("/rest/db")
public class DBServiceController {
	
	@Autowired
	private IQuoteRepository quoteRepository;
	
	@GetMapping("/{username}")
	public List<String> quotesByUsername(@PathVariable("username") String username){
		
		return getQuotesByUserName(username);
	}
	
	@PostMapping("/add")
	public List<String> add(@RequestBody QuoteDto quoteDto){
		quoteDto.getQuotes()
				.stream()
				.map(quote -> new Quote(quoteDto.getUsername(),quote))
				.forEach(quote -> quoteRepository.save(quote));
		
		return getQuotesByUserName(quoteDto.getUsername());
	}
	
	/*@PostMapping("/delete/{username}")
	public List<String> delete(@PathVariable("username") String username){
		
		List<Quote> quotes = quoteRepository.findByUsername(username);
		quoteRepository.delete(quotes);
	}*/
	
	 private List<String> getQuotesByUserName(@PathVariable("username") String username) {
	        return quoteRepository.findByUsername(username)
	                .stream()
	                .map(Quote::getQuotes)
	                .collect(Collectors.toList());
	    }
}
