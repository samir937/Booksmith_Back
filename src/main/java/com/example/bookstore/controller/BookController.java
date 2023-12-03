package com.example.bookstore.controller;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@CrossOrigin(origins={"https://booksmith-library.herokuapp.com","http://localhost:3000"})
public class BookController {
	
	@Autowired
	BookService bookservice;

	private Logger logger = LogManager.getLogger(BookController.class);

	@GetMapping("/books/list")
	@RateLimiter(name = "bookRateLimiter", fallbackMethod = "bookFallbackMethod")
	public ResponseEntity<List<Book>> getBookList()
	{
		List<Book> books=bookservice.getBookList();
		
		return ResponseEntity.ok(books);
	}
	
	@GetMapping("/book/{id}")
	public Book findBook(@PathVariable int id)
	{
		Book book=bookservice.findBook(id);
		return book;
		
	}
	
	@PostMapping("/books/list")
	public void addBook(@RequestBody Book bookData) {
		bookservice.addBook(bookData);
	}

	@DeleteMapping("/book/{id}")
	@CacheEvict(cacheNames = "product", key = "#id", beforeInvocation = true)
	public void deletBook(@PathVariable int id) {
		bookservice.deleteBook(id);
	}

	@DeleteMapping("/book/deleteAll")
	@CacheEvict(cacheNames = "product", allEntries = true)
	public void deletBook() {
		bookservice.deleteAllBook();
	}

	public ResponseEntity<List<Book>> bookFallbackMethod(Throwable t) {
		logger.info("Calling service in down !!!");
		return ResponseEntity.ok().body(Collections.emptyList());
	}

}
