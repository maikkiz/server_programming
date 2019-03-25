package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
    @Autowired
    private BookRepository repository;

    @Test
    public void findByAuthorShouldReturnBook() {
        List<Book> books = repository.findByAuthor("George Orwell");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Animal Farm");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Testi Kirja", "Testi Kirjailija", 2008, "556688-9", 30.0, new Category("Testi"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }

}
