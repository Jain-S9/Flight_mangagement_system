package com.example.flightmanagementsystem.controllers;

import com.example.flightmanagementsystem.entity.Flight;
import com.example.flightmanagementsystem.entity.Schedule;
import com.example.flightmanagementsystem.entity.ScheduledFlight;
import com.example.flightmanagementsystem.exceptions.AirportNotFoundException;
import com.example.flightmanagementsystem.exceptions.RecordNotFoundException;
import com.example.flightmanagementsystem.exceptions.ScheduledFlightNotFoundException;
import com.example.flightmanagementsystem.services.AirportService;
import com.example.flightmanagementsystem.services.Flightservice;
import com.example.flightmanagementsystem.services.ScheduledFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/scheduledFlight")
public class ScheduledFlightController {
    /*
     * Creating Service object
     */
    @Autowired
    ScheduledFlightService scheduleFlightService;

    @Autowired
    AirportService airportService;

    @Autowired
    Flightservice flightService;

    /*
     * Controller for adding Scheduled Flights
     */
    @PostMapping("/add")
    public ResponseEntity<ScheduledFlight> addSF(@RequestParam(name = "srcAirport") String source,
                                                 @RequestParam(name = "dstnAirport") String destination,
                                                 @RequestParam(name = "deptDateDate") String departureDate,
                                                 @RequestParam(name = "arrDateDate") String arrivalDate) throws AirportNotFoundException {
        ScheduledFlight scheduledFlight = new ScheduledFlight();
        Schedule schedule = new Schedule();
        schedule.setScheduleID(scheduledFlight.getScheduleFlightId());
        try {
            // AirportRepo airportrepo;
            scheduledFlight.schedule.setSourceAirport(source);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity("Airport Not Found", HttpStatus.BAD_REQUEST);
        }
        try {
            scheduledFlight.schedule.setDestinationAirport(destination);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity("Airport Not Found", HttpStatus.BAD_REQUEST);
        }
        scheduledFlight.schedule.setDepartureDate(departureDate);
        scheduledFlight.schedule.setArrivalDate(arrivalDate);
        try {
            scheduledFlight.setFlight((Flight) flightService.viewFlightById(scheduledFlight.getScheduleFlightId()));
        } catch (RecordNotFoundException e1) {
            return new ResponseEntity("Flight Not Found", HttpStatus.BAD_REQUEST);
        }
        scheduledFlight.setSchedule(schedule);
        scheduledFlight.setAvailableSeats(scheduledFlight.getFlight().getSeatCapacity());
        try {
            return new ResponseEntity<ScheduledFlight>(scheduleFlightService.addScheduledFlight(scheduledFlight),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error adding Flight." + e, HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * Controller for modifying existing Scheduled Flights
     */
    @PutMapping("/modify")
    public ResponseEntity<ScheduledFlight> modifyScheduleFlight(@ModelAttribute ScheduledFlight scheduleFlight) {
        ScheduledFlight modifySFlight = scheduleFlightService.modifyScheduledFlight(scheduleFlight);
        if (modifySFlight == null) {
            return new ResponseEntity("Flight not modified", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<ScheduledFlight>(modifySFlight, HttpStatus.OK);
        }

    }

    /*
     * Controller for deleting existing Scheduled Flights
     */
    @DeleteMapping("/delete")
    public String deleteSF(@RequestParam BigInteger flightId) throws RecordNotFoundException {
        return scheduleFlightService.removeScheduledFlight(flightId);
    }

    /*
     * Controller for viewing a Scheduled Flight by ID
     */
    @GetMapping("/search")
    @ExceptionHandler(ScheduledFlightNotFoundException.class)
    public ResponseEntity<ScheduledFlight> viewSF(@RequestParam BigInteger flightId)
            throws ScheduledFlightNotFoundException {
        ScheduledFlight searchSFlight = scheduleFlightService.viewScheduledFlight(flightId);
        if (searchSFlight == null) {
            return new ResponseEntity("Flight not present", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<ScheduledFlight>(searchSFlight, HttpStatus.OK);
        }
    }

    /*
     * Controller for viewing all Scheduled Flights
     */
    @GetMapping("/viewAll")
    public Iterable<ScheduledFlight> viewAllSF() {
        return scheduleFlightService.viewAllScheduledFlights();
    }
}
