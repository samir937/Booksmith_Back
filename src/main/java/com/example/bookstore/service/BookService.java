package com.example.bookstore.service;

import java.util.List;

import com.example.bookstore.entity.Book;

public interface BookService {
	
	public List<Book> getBookList();

	public void addBook(Book bookData);

	public void deleteBook(int id);

	public Book findBook(int id);
}
