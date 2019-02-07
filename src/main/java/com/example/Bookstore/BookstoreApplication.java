package com.example.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	@Autowired
	private BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return(args)-> {
			Book book = new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 30.00, 1);
			repository.save(book);
			
			book = new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 25.0, 2);
			repository.save(book);
		};

	}
}
