package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return(args)-> {
			Category category = new Category("Literature & Fiction");
			crepository.save(category);
			category = new Category("Health & Fitness");
			crepository.save(category);
			category = new Category("Parenting");
			crepository.save(category);
			category = new Category("Sci-fi & Fantasy");
			crepository.save(category);
			category = new Category("Computers & Tech");
			crepository.save(category);
			
			Book book = new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 30.0, crepository.findByName("Literature & Fiction").get(0));
			brepository.save(book);
			book = new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 25.0, crepository.findByName("Literature & Fiction").get(0));
			brepository.save(book);
		};
		
	}
	
}
