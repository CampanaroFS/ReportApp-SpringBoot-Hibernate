package com.felipedeveloper.reportapp.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipedeveloper.reportapp.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = new User(null, "teste test", "teste@test.com", "Maintenance engineer", 20001000, "123456");
		return ResponseEntity.ok().body(user);
	}

}
