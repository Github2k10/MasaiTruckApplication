package com.masai.service;

import java.util.List;

import com.masai.module.Truck;

public interface TruckService {
	public List<Truck> geTrucks();
	
	public Truck geTruckById(Integer id);
}
