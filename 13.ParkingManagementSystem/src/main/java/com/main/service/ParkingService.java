package com.main.service;

import java.util.Optional;

import com.main.model.Parking;

public interface ParkingService {
	
	 Parking createParking(Integer size);
	    Optional<Parking> getParkingById(Long id);
	    long getAvailableBays(Parking parking);
	    boolean unparkCar(Parking parking, int index);
	    String printParking(Parking parking);
	    
	}