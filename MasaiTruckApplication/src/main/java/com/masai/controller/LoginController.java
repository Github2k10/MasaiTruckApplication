package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.module.User;
import com.masai.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
public class LoginController {
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/signIn")
	public ResponseEntity<User> userLoginHandler(Authentication auth){
		System.out.println(auth);
		
		User user = repository.findByUsername(auth.getName());
		
		if(user == null) {
			throw new BadCredentialsException("Invalid username or password!!!");
		}
		
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}
}
