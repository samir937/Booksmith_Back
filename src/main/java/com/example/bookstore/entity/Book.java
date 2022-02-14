package com.example.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String BookName;
	private String Author;
	private String Description;
	private String publisher;
	private String BookImageUrl;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return BookName;
	}


	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getAuthor() {
		return Author;
	}


	public void setAuthor(String author) {
		Author = author;
	}

	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookImageUrl() {
		return BookImageUrl;
	}

	public void setBookImageUrl(String bookImageUrl) {
		BookImageUrl = bookImageUrl;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", BookName=" + BookName + ", Author=" + Author + ", BookImageUrl=" + BookImageUrl
				+ ", publisher=" + publisher + ", Description=" + Description + "]";
	}
	
	
	

}
