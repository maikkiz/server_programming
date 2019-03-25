package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository crepository;
	
    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = crepository.findByName("Parenting");
        
        assertThat(categories).hasSize(1);
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Testi");
    	crepository.save(category);
    	assertThat(category.getCategoryid()).isNotNull();
    }

}
