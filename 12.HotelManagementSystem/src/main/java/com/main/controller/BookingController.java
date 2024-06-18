package com.main.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.main.model.Booking;
import com.main.service.BookingService;

@RestController
//@RequestMapping("/api/bookings")
@CrossOrigin("*")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@GetMapping("/getAllBookings")
	public List<Booking> getAllBookings() {
		return bookingService.getAllBookings();
	}

	@PostMapping("/saveBooking")
	public Booking saveBooking(@RequestBody Booking booking) {

		booking.setCheckIn(LocalDate.now());

		booking.setCheckOut(LocalDate.now().plus(5, ChronoUnit.DAYS));
		return bookingService.saveBooking(booking);
	}

	@DeleteMapping("/delete/{bookingId}")
	public ResponseEntity<String> deleteBookingById(@PathVariable Long bookingId) {
		bookingService.deleteBookingById(bookingId);
		return new ResponseEntity<>("Booking with ID " + bookingId + " deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/getById/{bookingId}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
		Booking booking = bookingService.getBookingById(bookingId);
		if (booking != null) {
			return ResponseEntity.ok(booking);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}