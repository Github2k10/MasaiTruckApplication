package com.masai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.repository.UserRepository;

@Service
public class CustomUserDetails implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.masai.module.User user = userRepository.findByUsername(username);
		
		if(user != null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			return new User(user.getUsername(), user.getPassword(), authorities);
		} else {
			throw new BadCredentialsException("User not found with the given username " + username);
		}
	}

}
