package com.example.flightmanagementsystem.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ToString
@Table(name = "ScheduledFlights")
public class ScheduledFlight {

    @Id
    @Column(name = "schedule_flight_id")
    private String scheduleFlightId;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private Flight flight;

    @Column(name = "available_seats")
    @NotNull
    private Integer availableSeats;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    public Schedule schedule;

    /*
     * Default constructor
     */
    public ScheduledFlight() {

    }

    public String getScheduleFlightId() {
        return scheduleFlightId;
    }

    public void setScheduleFlightId(String scheduleFlightId) {
        this.scheduleFlightId = scheduleFlightId;
    }

    /*
     * Getter and setter for Available seats
     */
    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }


    /**
     * @return the flight
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * @param flight the flight to set
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * @return the schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * @param schedule the schedule to set
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /**
     * @param availableSeats the availableSeats to set
     */
    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "ScheduledFlight [scheduleFlightId=" + scheduleFlightId + ", flight=" + flight + ", availableSeats="
                + availableSeats + ", schedule=" + schedule + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((availableSeats == null) ? 0 : availableSeats.hashCode());
        result = prime * result + ((flight == null) ? 0 : flight.hashCode());
        result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
        result = prime * result + ((scheduleFlightId == null) ? 0 : scheduleFlightId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ScheduledFlight other = (ScheduledFlight) obj;
        if (availableSeats == null) {
            if (other.availableSeats != null)
                return false;
        } else if (!availableSeats.equals(other.availableSeats))
            return false;
        if (flight == null) {
            if (other.flight != null)
                return false;
        } else if (!flight.equals(other.flight))
            return false;
        if (schedule == null) {
            if (other.schedule != null)
                return false;
        } else if (!schedule.equals(other.schedule))
            return false;
        if (scheduleFlightId == null) {
            if (other.scheduleFlightId != null)
                return false;
        } else if (!scheduleFlightId.equals(other.scheduleFlightId))
            return false;
        return true;
    }
}
