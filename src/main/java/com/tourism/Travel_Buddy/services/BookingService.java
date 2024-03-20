package com.tourism.Travel_Buddy.services;

import com.tourism.Travel_Buddy.model.PackageBooking;
import com.tourism.Travel_Buddy.model.Packages;
import com.tourism.Travel_Buddy.model.User;
import com.tourism.Travel_Buddy.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {


    @Autowired
    private BookingRepository bookingRepository;


    //---------------------------------Add Package-------------------------------------------------

    public PackageBooking createBooking(PackageBooking booking) {
        return bookingRepository.save(booking);
    }


    //---------------------------------Get Booking-------------------------------------------------

    public Optional<PackageBooking> getBookingById(int id) {
        return bookingRepository.findById(id);
    }


    //---------------------------------Get all Booking-------------------------------------------------

    public List<PackageBooking> getAllBookings() {
        return bookingRepository.findAll();
    }


    //---------------------------------Get all Booking by user-------------------------------------------------

    public List<PackageBooking> getBookingByUsername(String username) {
        return bookingRepository.findByUsername(username);
    }


    //---------------------------------Delete Booking-------------------------------------------------

}