package com.main.controller;

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

import com.main.model.Parking;
import com.main.model.ParkingRequest;
import com.main.service.ParkingService;

@CrossOrigin("*")
@RestController
public class ParkingController {

	
	@Autowired
    private ParkingService parkingService;

	 @PostMapping("/createParking")
	    public ResponseEntity<Parking> createParking(@RequestBody ParkingRequest request) {
	        Integer size = request.getSize();
	        if (size == null) {
	            return ResponseEntity.badRequest().body(null);
	        }
	        Parking parking = parkingService.createParking(size);
	        return ResponseEntity.ok(parking);
	    }

    @GetMapping("/available/{id}")
    public ResponseEntity<Long> getAvailableBays(@PathVariable Long id) {
        Optional<Parking> parkingOpt = parkingService.getParkingById(id);
        return parkingOpt.map(parking -> ResponseEntity.ok(parkingService.getAvailableBays(parking)))
                         .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PutMapping("/unpark/{id}/{index}")
    public ResponseEntity<Boolean> unparkCar(@PathVariable Long id, @PathVariable Integer index) {
        Optional<Parking> parkingOpt = parkingService.getParkingById(id);
        return parkingOpt.map(parking -> ResponseEntity.ok(parkingService.unparkCar(parking, index)))
                         .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/printParking/{id}")
    public ResponseEntity<String> printParking(@PathVariable Long id) {
        Optional<Parking> parkingOpt = parkingService.getParkingById(id);
        return parkingOpt.map(parking -> ResponseEntity.ok(parkingService.printParking(parking)))
                         .orElseGet(() -> ResponseEntity.noContent().build());
    }
}