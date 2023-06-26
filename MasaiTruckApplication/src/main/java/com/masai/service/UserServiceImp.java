package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserExcepiton;
import com.masai.module.User;
import com.masai.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository repository;
	
	@Override
	public User adduUser(User user) {
		if(user == null) throw new UserExcepiton("User objecr is empty");
		
		if(repository.findByUsername(user.getUsername()) != null) throw new UserExcepiton("User with the given username is already present: " + user.getUsername());
		
		User user2 = repository.save(user);
		
		return user2;
	}
}
