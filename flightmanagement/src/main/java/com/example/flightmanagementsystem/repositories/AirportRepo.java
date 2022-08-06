package com.example.flightmanagementsystem.repositories;

import com.example.flightmanagementsystem.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepo extends JpaRepository<Airport, String> {
    List<Airport> findByairportId(String airportID);

    List<Airport> findByairportName(String aiportName);

    // String deleteByFlightId(String flightId);
//	List<Flight> findByName(String name);
    //String deleteByairportName(String airportName);
    String deleteByairportName(String airportName);


}
