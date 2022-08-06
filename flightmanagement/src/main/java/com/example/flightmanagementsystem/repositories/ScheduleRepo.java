package com.example.flightmanagementsystem.repositories;

import com.example.flightmanagementsystem.entity.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScheduleRepo extends CrudRepository<Schedule, String> {


}

