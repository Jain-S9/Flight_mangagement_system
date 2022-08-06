package com.example.flightmanagementsystem.services;

import com.example.flightmanagementsystem.entity.ScheduledFlight;
import com.example.flightmanagementsystem.exceptions.RecordNotFoundException;
import com.example.flightmanagementsystem.exceptions.ScheduledFlightNotFoundException;

import java.math.BigInteger;

public interface ScheduledFlightService {
    public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);

    public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);

    public String removeScheduledFlight(BigInteger id) throws RecordNotFoundException;

    public Iterable<ScheduledFlight> viewAllScheduledFlights();

    public ScheduledFlight viewScheduledFlight(BigInteger id) throws ScheduledFlightNotFoundException;
}