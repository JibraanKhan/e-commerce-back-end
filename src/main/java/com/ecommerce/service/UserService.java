package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository repo;
	
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public User registerUser(User user) {
		User registeredUser = repo.save(user);
		
		System.out.println("User is being saved: " + registeredUser);

		return registeredUser;
	}
	
	public List<User> getAllusers() {
		return repo.findAll();
	}
	
	public User findUserById(Long user_id) {
		Optional<User> optional = repo.findById(user_id);
		
		return optional.isEmpty() ? null : optional.get();
	}
	
	public User loginuser(String username, String password_hash) {
		Optional<User> optional = repo.findByUsernameAndPasswordHash(username, password_hash);
		
		Optional<User> optionalByUsername = repo.findByUsername(username);
//		Optional<User> optionalByPassword = repo.findByPasswordHash(password_hash);
		
		System.out.println("Optional By Username: " + username + (optionalByUsername.isEmpty() ? null : optionalByUsername.get()));
//		System.out.println("Optional By Password: " + password_hash + (optionalByPassword.isEmpty() ? null : optionalByPassword.get()));
		
		return optional.isEmpty() ? null : optional.get();
	}
}
