package com.example.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;

@Service
@Transactional
public class BookserviceImpl implements BookService{

	@Autowired
	BookRepository repo;
	
	@Override
	public List<Book> getBookList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	@Override
	public void addBook(Book bookData) {
		// TODO Auto-generated method stub
		repo.save(bookData);
	}

	@Override
	public void deleteBook(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public Book findBook(int id) {
		// TODO Auto-generated method stub
		Book book=repo.findById(id).get();
		return book ;
	}


	@Override
	public void deleteAllBook() {
		repo.deleteAll();
		
	}
	
	

}
