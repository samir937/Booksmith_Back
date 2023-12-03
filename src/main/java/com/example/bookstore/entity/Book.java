package com.example.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import java.io.Serializable;

@Entity
@Data
public class Book implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String BookName;
	private String Author;
	private String Description;
	private String publisher;
	private String BookImageUrl;

}
