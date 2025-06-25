package com.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/")
	public String home() {
		return "Welcome to our REST API for our e-commerce-database. Lucky to have you here! :D";
	}
	
	@GetMapping("/**")
	public ResponseEntity<String> endpointNotFound() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("API Endpoint Not Found");
	}
}
