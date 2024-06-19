package com.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.ParkingSpot;
import com.main.repository.ParkingSpotRepository;
import com.main.service.ParkingSpotService;

@RestController
//@RequestMapping("/api/parking-spots")
@CrossOrigin("*")
public class ParkingSpotController {
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    ParkingSpotService ps;
    
    @GetMapping("/getAllParkingSpots")
    public List<ParkingSpot> getAllParkingSpots() {
//        return parkingSpotRepository.findAll();
    	return ps.getAllParkingSpots();
    }

    @PutMapping("/updateParkingSpot/{id}")
    public ResponseEntity<ParkingSpot> updateParkingSpot(@PathVariable Long id, @RequestBody ParkingSpot updatedSpot) {
        Optional<ParkingSpot> existingSpotOptional = parkingSpotRepository.findById(id);
        if (!existingSpotOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        ParkingSpot existingSpot = existingSpotOptional.get();
        existingSpot.setNumber(updatedSpot.getNumber());
        existingSpot.setOccupied(updatedSpot.isOccupied());
        existingSpot.setVehicleNumber(updatedSpot.getVehicleNumber());
        existingSpot.setOccupantName(updatedSpot.getOccupantName());
        existingSpot.setCheckInTime(updatedSpot.getCheckInTime());
        existingSpot.setCheckOutTime(updatedSpot.getCheckOutTime());

        ParkingSpot updatedSpot1 = parkingSpotRepository.save(existingSpot);
        return ResponseEntity.ok(updatedSpot1);
    }

    @PostMapping("/createParkingSpot")
    public ResponseEntity<ParkingSpot> createParkingSpot(@RequestBody ParkingSpot newSpot) {
        ParkingSpot savedSpot = parkingSpotRepository.save(newSpot);
        return ResponseEntity.ok(savedSpot);
    }
}