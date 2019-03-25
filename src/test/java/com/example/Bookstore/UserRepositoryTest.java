package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
    @Autowired
    private UserRepository urepository;

    @Test
    public void findByUsernameShouldReturnUser() {
        List<User> users = urepository.findByUsername("user");
        
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getEmail()).isEqualTo("user@email.com");
    }
    
    @Test
    public void createNewUser() {
    	User user = new User("testi", "$2b$10$rXoOJjei8dbSMN57I5iBQu696MmhL1VLsp2Ob0Q0x4d3F07n3PvFm", "testi@email.com", "USER");
    	urepository.save(user);
    	assertThat(user.getId()).isNotNull();
    }

}
