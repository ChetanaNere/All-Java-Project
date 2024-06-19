package com.main.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Parking;
import com.main.repository.ParkingRepository;

@Service
public class ParkingServiceImpl implements ParkingService
{
	 @Autowired
	    private ParkingRepository parkingRepository;

	    @Override
	    public Parking createParking(Integer size) {
	        Parking parking = new Parking();
	        parking.setSize(size);
	        parking.setBays(new ArrayList<>(Collections.nCopies(size, Boolean.FALSE)));
	        return parkingRepository.save(parking);
	    }

	    @Override
	    public Optional<Parking> getParkingById(Long id) {
	        return parkingRepository.findById(id);
	    }

	    @Override
	    public long getAvailableBays(Parking parking) {
	        return parking.getBays().stream().filter(bay -> !bay).count();
	    }

	    @Override
	    public boolean unparkCar(Parking parking, int index) {
	        if (index >= 0 && index < parking.getSize() && parking.getBays().get(index)) {
	            parking.getBays().set(index, Boolean.FALSE);
	            parkingRepository.save(parking);
	            return true;
	        }
	        return false;
	    }

	    @Override
	    public String printParking(Parking parking) {
	        StringBuilder sb = new StringBuilder();
	        for (Boolean bay : parking.getBays()) {
	            sb.append(bay ? "[Occupied] " : "[Free] ");
	        }
	        return sb.toString();
	    }
	}