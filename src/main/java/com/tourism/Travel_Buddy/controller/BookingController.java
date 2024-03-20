package com.tourism.Travel_Buddy.controller;

import com.tourism.Travel_Buddy.model.PackageBooking;
import com.tourism.Travel_Buddy.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class BookingController {

    @Autowired
    private BookingService bookingService;

    //------------------------Get booking----------------------------------------------------------------
    @GetMapping("/getAllBooking")
    public List<PackageBooking> getAllBookings() {

        return bookingService.getAllBookings();
    }

    @GetMapping("/getBookingById")
    public Optional<PackageBooking> getBookingById(@RequestParam int id) {
        return bookingService.getBookingById(id);
    }


    @GetMapping("/getBookingByUserId")
    public List<PackageBooking> getBookingByUserId(@RequestParam("username") String username) {
        return bookingService.getBookingByUsername(username);
    }

    //------------------------ADD booking----------------------------------------------------------------

    @PostMapping("/addBooking")
    public PackageBooking createBooking(@RequestBody PackageBooking booking) {
        System.out.println("add booking controller");
        return bookingService.createBooking(booking);
    }

    //------------------------Update booking----------------------------------------------------------------

//    @PutMapping("/updateBooking/{id}")
//    public PackageBooking updateBooking(@PathVariable int id, @RequestBody PackageBooking packageBooking) {
//        return bookingService.updateBooking(id, packageBooking);
//    }

    //------------------------Delete booking----------------------------------------------------------------

//    @DeleteMapping("/deleteBooking/{id}")
//    public void deleteBooking(@PathVariable int id) {
//        bookingService.deleteBooking(id);
//    }

    
}
