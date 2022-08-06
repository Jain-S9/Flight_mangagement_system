package com.example.flightmanagementsystem.services;

import com.example.flightmanagementsystem.entity.Airport;
import com.example.flightmanagementsystem.repositories.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    private AirportRepo airportrepo;

    public List<Airport> viewAllAirport() {
        return (List<Airport>) airportrepo.findAll();
    }

    public String viewairportById(String airportId) {
        if (airportrepo.existsById(airportId)) {
            Airport airport = airportrepo.getReferenceById(airportId);
            return "Airport Found\n" + airport;
        } else
            return "AirportID Not Found";
    }

    public String removeAirportId(String airportId) {
        if (airportrepo.existsById(airportId)) {
            Airport airport = airportrepo.getReferenceById(airportId);
            airportrepo.deleteById(airportId);
            return "Airport " + airportId + " Deleted";

        } else {
            return "Airport Id not Found";

        }
    }

    public String addAirport(Airport airport) {
        if (airport.getAirportName().isEmpty() || airport.getAirportLocation().isEmpty()) {
            return "Please fill all fields";
        } else {
            airportrepo.save(airport);
            return "Airport Added Successfully " + airport.getAirportId();
        }
    }

    public String modifyAirport(String airportid, Airport airport) {
        if (airportrepo.existsById(airportid)) {
            if (airport.getAirportName().isEmpty() || airport.getAirportLocation().isEmpty()) {
                return "Please fill all fields";
            } else {
                Airport airport1 = airportrepo.getReferenceById(airportid);
                airport1.setAirportName(airport.getAirportName());
                airport1.setAirportLocation(airport.getAirportLocation());
                airportrepo.save(airport1);
                return "Airport Updated Successfully\n" + airport1;
            }
        } else return "Airport Id not Found";
    }
}