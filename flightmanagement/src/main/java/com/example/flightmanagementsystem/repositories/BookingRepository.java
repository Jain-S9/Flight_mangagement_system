package com.example.flightmanagementsystem.repositories;

import com.example.flightmanagementsystem.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByBookingId(Integer bid);

    boolean existsById(Integer bid);

    void deleteById(Integer bid);

}