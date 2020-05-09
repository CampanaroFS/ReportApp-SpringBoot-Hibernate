package com.felipedeveloper.reportapp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipedeveloper.reportapp.entities.User;
import com.felipedeveloper.reportapp.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Felipe Campanaro", "felipe@gmail.com", "Maintenance Manager", 20001000, "123456");
		User user2 = new User(null, "Maria Brown", "maria@hotmail.com", "Maintenance Supervisor", 2000950, "123456");
		User user3 = new User(null, "Alex John", "felipe@gmail.com", "Electrical Engineer", 2000504, "123456");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
	}
	
	

}
