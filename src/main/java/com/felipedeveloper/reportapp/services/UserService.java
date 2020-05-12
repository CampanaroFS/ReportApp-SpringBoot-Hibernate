package com.felipedeveloper.reportapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipedeveloper.reportapp.entities.User;
import com.felipedeveloper.reportapp.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public Optional<User> findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj;
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public User update(Long id, User obj) {
		User user = repository.getOne(id);
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		user.setPosition(obj.getPosition());
		user.setRegistrationNumber(obj.getRegistrationNumber());
		user.setPassword(obj.getPassword());
		
		return repository.save(user);
	}

}
