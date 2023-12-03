package com.example.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TouchingLiveBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TouchingLiveBookStoreApplication.class, args);
	}

}
