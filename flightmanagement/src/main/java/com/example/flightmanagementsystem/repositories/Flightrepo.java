package com.example.flightmanagementsystem.repositories;

import com.example.flightmanagementsystem.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Flightrepo extends JpaRepository<Flight, String> {
    List<Flight> findByFlightId(String userId);
    // String deleteByFlightId(String flightId);
//	List<Flight> findByName(String name);

}
