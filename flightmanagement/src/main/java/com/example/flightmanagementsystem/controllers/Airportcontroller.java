package com.example.flightmanagementsystem.controllers;

import com.example.flightmanagementsystem.entity.Airport;
import com.example.flightmanagementsystem.exceptions.AirportNotFoundException;
import com.example.flightmanagementsystem.exceptions.ListEmptyException;
import com.example.flightmanagementsystem.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class Airportcontroller {
    @Autowired
    private AirportService airportservice;

    @PostMapping(value = "/flight/addAirport", consumes = "application/json")
    public String addAirport(@RequestBody Airport airport) {
        Random rand = new Random();
        int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
        airport.setAirportId(Integer.toString(resRandom));
        return airportservice.addAirport(airport);
    }

    @GetMapping("/viewAirport")
    public List<Airport> viewAirport() throws ListEmptyException {
        if (airportservice.viewAllAirport().isEmpty())
            throw new ListEmptyException();
        return airportservice.viewAllAirport();
    }

    @GetMapping(value = "/viewAirportById/{airportId}")
    public String viewAirportByID(@PathVariable("airportId") String airportId) throws AirportNotFoundException {
        if (airportservice.viewairportById(airportId).isEmpty())
            throw new AirportNotFoundException();
        System.out.println("Fetched Successfully");
        return airportservice.viewairportById(airportId);
    }

    @DeleteMapping(value = "/delete/{airportId}")
    public String deleteAirport(@PathVariable String airportId) {
        return airportservice.removeAirportId(airportId);
    }

    @PutMapping(value = "/updateAirport/{airportId}")
    public String updateAirport(@PathVariable(value = "airportId") String airportId, @RequestBody Airport airport) {
        return airportservice.modifyAirport(airportId, airport);
    }

}
