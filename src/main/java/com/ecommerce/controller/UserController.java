package com.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;

@RestController
public class UserController {
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/users/")
	public ResponseEntity<?> getAllusers() {
		List<User> allUsers = service.getAllusers();
		
		if (allUsers != null) {
			return ResponseEntity.ok().body(allUsers);
		}
		
		return ResponseEntity.internalServerError().body("Could not fetch users for some reason.");
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Long userId) {
		System.out.println(userId);
		User user = service.findUserById(userId);
		
		if (user != null) {
			return ResponseEntity.ok().body(user);
		}
		
		return ResponseEntity.badRequest().body("Could not fetch user by id for some reason.");
	}
	
	@PostMapping("/user/")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		User registeredUser = service.registerUser(user);
		System.out.println("user registered maybe");

		System.out.println("Registered user: " + registeredUser);
		
		if (registeredUser != null) {
			return ResponseEntity.created(null).body(registeredUser);
		}
		
		return ResponseEntity.badRequest().body("Failed to register user for some reason.");
	}
	
	@PostMapping("/users/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		User loggedInUser = service.loginuser(user.getUsername(), user.getPasswordHash());
		
		if (loggedInUser != null) {
			return ResponseEntity.ok().body(loggedInUser);
		}
		
		return ResponseEntity.badRequest().body("Incorrect credentials.");
	}
}
