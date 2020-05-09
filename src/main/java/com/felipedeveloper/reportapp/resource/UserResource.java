package com.felipedeveloper.reportapp.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipedeveloper.reportapp.entities.User;
import com.felipedeveloper.reportapp.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> user = userService.findAll();
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Long id){
		Optional<User> obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletebyId(@PathVariable Long id){
		userService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
