package com.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByUsernameAndPasswordHash(String username, String passwordHash);
	
	public Optional<User> findByUsername(String username);
	
	public Optional<User> findByPasswordHash(String passwordHash);

}
