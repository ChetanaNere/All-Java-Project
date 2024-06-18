package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import com.main.model.Booking;
import com.main.model.Room;
import com.main.model.User;
import com.main.repositoryy.BookingRepository;
import com.main.repositoryy.RoomRepository;
import com.main.repositoryy.UserRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoomRepository roomRepository;
    
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
   

    public void deleteBookingById(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
    
    public Booking getBookingById(Long bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        return optionalBooking.orElse(null);
    }
}
