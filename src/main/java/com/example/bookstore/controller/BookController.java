package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
