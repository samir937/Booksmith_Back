package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookservice;
	
	@GetMapping("/books/list")
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
	public void addBook(@RequestBody Book bookData)
	{
		bookservice.addBook(bookData);
	}
	
	@DeleteMapping("")
	public void deletBook(@PathVariable int id)
	{
		bookservice.deleteBook(id);
	}
	

}
