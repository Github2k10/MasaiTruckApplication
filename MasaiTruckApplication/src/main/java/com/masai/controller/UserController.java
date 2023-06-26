package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.module.Truck;
import com.masai.module.User;
import com.masai.service.TruckService;
import com.masai.service.UserService;

import java.util.*;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TruckService truckService; 
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		return "Welcome to the Masai Truck Application";
	}
	
	@PostMapping("/signup")
	public ResponseEntity<User> addUserHandler(@RequestBody User user){
		System.out.println(user);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User registerdUser = userService.adduUser(user);
		
		return new ResponseEntity<>(registerdUser, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/vechiles")
	public ResponseEntity<List<Truck>> getAllTruck(){
		List<Truck> trucks = truckService.geTrucks();
		
		return new ResponseEntity<List<Truck>>(trucks, HttpStatus.OK);
	}
	
	@GetMapping("/manager/{id}")
	public ResponseEntity<Truck> getTruckById(@PathVariable Integer id){
		Truck truck = truckService.geTruckById(id);
		
		return new ResponseEntity<Truck>(truck, HttpStatus.OK);
	}
}
