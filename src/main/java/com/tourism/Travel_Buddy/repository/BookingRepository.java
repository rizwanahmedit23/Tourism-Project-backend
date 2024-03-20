package com.tourism.Travel_Buddy.repository;

import com.tourism.Travel_Buddy.model.PackageBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<PackageBooking, Integer> {

    List<PackageBooking> findByUsername(String username);
}