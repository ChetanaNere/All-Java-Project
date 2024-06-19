package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.ParkingSpot;
import com.main.repository.ParkingSpotRepository;

@Service
public class ParkingSpotService {

	 @Autowired
	    private ParkingSpotRepository parkingSpotRepository;

	 
	public List<ParkingSpot> getAllParkingSpots() {
		// TODO Auto-generated method stub
		return parkingSpotRepository.findAll();
	}

}
