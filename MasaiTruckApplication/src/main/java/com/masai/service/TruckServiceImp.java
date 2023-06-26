package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserExcepiton;
import com.masai.module.Truck;
import com.masai.repository.TruckRepository;

@Service
public class TruckServiceImp implements TruckService{
	@Autowired
	private TruckRepository repository;
	
	@Override
	public List<Truck> geTrucks(){
		if(repository.findAll().isEmpty()) throw new UserExcepiton("Vechiles not found");
		
		return repository.findAll();
	}
	
	@Override
	public Truck geTruckById(Integer id) {
		Optional<Truck> optional = repository.findById(id);
		
		if(optional.isEmpty()) throw new UserExcepiton("Truck not found with the given id: " + id);
		
		return optional.get();
	}
}
