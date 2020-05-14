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
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public Optional<User> findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj;
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public User update(Long id, User obj) {
		User user = userRepository.getOne(id);
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		user.setPosition(obj.getPosition());
		user.setRegistrationNumber(obj.getRegistrationNumber());
		user.setPassword(obj.getPassword());
		
		return userRepository.save(user);
	}
}
