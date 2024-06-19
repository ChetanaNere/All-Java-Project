package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
	
	
}