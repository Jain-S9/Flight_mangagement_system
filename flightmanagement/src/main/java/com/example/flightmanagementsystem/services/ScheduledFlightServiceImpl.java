package com.example.flightmanagementsystem.services;

import com.example.flightmanagementsystem.entity.Schedule;
import com.example.flightmanagementsystem.entity.ScheduledFlight;
import com.example.flightmanagementsystem.exceptions.RecordNotFoundException;
import com.example.flightmanagementsystem.exceptions.ScheduledFlightNotFoundException;
import com.example.flightmanagementsystem.repositories.ScheduleRepo;
import com.example.flightmanagementsystem.repositories.ScheduledFlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {

    /*
     * Creating DAO object
     */
    @Autowired
    ScheduledFlightRepo dao;

    @Autowired
    ScheduleRepo scheduleDao;

    @Autowired
    BookingService bookingService;

    /*
     * Service method to add new Scheduled flight to database
     */
    @Override
    public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
        return dao.save(scheduledFlight);
    }

    /*
     * Service method to modify existing Scheduled flight in database
     */
    @Override
    public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduleFlight) {
        ScheduledFlight updateScheduleFlight = dao.findById(scheduleFlight.getScheduleFlightId()).get();
        Schedule updateSchedule = scheduleDao.findById(scheduleFlight.getScheduleFlightId()).get();
        updateScheduleFlight.setAvailableSeats(scheduleFlight.getAvailableSeats());
        updateSchedule.setSourceAirport(scheduleFlight.getSchedule().getSourceAirport());
        updateSchedule.setDestinationAirport(scheduleFlight.getSchedule().getDestinationAirport());
        updateSchedule.setArrivalDate(scheduleFlight.getSchedule().getArrivalDate());
        updateSchedule.setDepartureDate(scheduleFlight.getSchedule().getDepartureDate());
        dao.save(updateScheduleFlight);
        return scheduleFlight;
    }

    /*
     * Service method to remove existing Scheduled flight from database
     */
    public String removeScheduledFlight(String flightId) throws RecordNotFoundException {
        if (flightId == null)
            throw new RecordNotFoundException(/*"Enter flight Id"*/);
        Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
        if (!scheduleFlight.isPresent())
            throw new RecordNotFoundException(/*"Enter a valid Flight Id"*/);
        else {
            // try {
            // cancelBookings(flightId);
            // } catch (RecordNotFoundException e) {
            // System.out.println("No Bookings Found");
            // }
            dao.deleteById(flightId);
        }
        return "Scheduled flight with ID " + flightId + " is not found";
    }

    // @Override
    // public boolean cancelBookings(BigInteger flightId) throws
    // RecordNotFoundException {
    // Iterable<Booking> bookingList = bookingService.displayAllBooking();
    // for (Booking booking : bookingList) {
    // if (booking.getScheduleFlight().getScheduleFlightId().equals(flightId)) {
    // bookingService.deleteBooking(booking.getBookingId());
    // }
    // }
    // return true;
    // }

    /*
     * Service method to view all Scheduled flights in database
     */
    @Override
    public Iterable<ScheduledFlight> viewAllScheduledFlights() {
        return dao.findAll();
    }

    /*
     * Service method to view a Scheduled flight by ID from database
     */
    public ScheduledFlight viewScheduledFlight(String flightId) throws ScheduledFlightNotFoundException {
        if (flightId == null)
            throw new ScheduledFlightNotFoundException("Enter flight Id");
        Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
        if (!scheduleFlight.isPresent())
            throw new ScheduledFlightNotFoundException("Enter a valid Flight Id");
        else
            return scheduleFlight.get();
    }

    @Override
    public String removeScheduledFlight(BigInteger id) throws RecordNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ScheduledFlight viewScheduledFlight(BigInteger id) throws ScheduledFlightNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

}