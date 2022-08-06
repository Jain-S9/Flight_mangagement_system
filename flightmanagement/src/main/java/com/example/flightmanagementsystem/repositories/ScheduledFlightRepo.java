package com.example.flightmanagementsystem.repositories;

import com.example.flightmanagementsystem.entity.ScheduledFlight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduledFlightRepo extends CrudRepository<ScheduledFlight, String> {

    Optional<ScheduledFlight> findById(String flightId);


}
