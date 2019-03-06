package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
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
			
			// Create users: admin/admin user/user
			User user = new User("user", "$2a$10$fdyVvPFWxvJWlF/TRqU9lOvySDdNU85WC12FioV8HflzorgHhxsiO", "user@email.com", "USER");
			urepository.save(user);
			
			user = new User("admin", "$2a$10$vLQUan20K.TUkb275AAa1erTGwngYIOFnwyv0OaD1EYSSG1KtO.Qa", "admin@email.com", "ADMIN");
			urepository.save(user);
		};
		
	}
	
}
