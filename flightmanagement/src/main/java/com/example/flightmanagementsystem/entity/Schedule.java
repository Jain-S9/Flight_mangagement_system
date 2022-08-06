package com.example.flightmanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "schedule")
public class Schedule {
    @Id
    private String scheduleID;
    // @OneToOne(cascade = CascadeType.MERGE)
    private String sourceAirport;
    // @OneToOne(cascade = CascadeType.MERGE)
    private String destinationAirport;
    private String arrivalDate;
    private String departureDate;
    private Integer ticketcost;

    /**
     * @return the ticketcost
     */
    public Integer getTicketcost() {
        return ticketcost;
    }

    /**
     * @param ticketcost the ticketcost to set
     */
    public void setTicketcost(Integer ticketcost) {
        this.ticketcost = ticketcost;
    }

    /**
     * @return the scheduleID
     */
    public String getScheduleID() {
        return scheduleID;
    }

    /**
     * @param string the scheduleID to set
     */
    public void setScheduleID(String string) {
        this.scheduleID = string;
    }

    /**
     * @return the sourceAirport
     */
    public String getSourceAirport() {
        return sourceAirport;
    }

    /**
     * @param source the sourceAirport to set
     */
    public void setSourceAirport(String source) {
        this.sourceAirport = source;
    }

    /**
     * @return the destinationAirport
     */
    public String getDestinationAirport() {
        return destinationAirport;
    }

    /**
     * @param destinationAirport the destinationAirport to set
     */
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    /**
     * @return the airrivalDate
     */
    public String getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param airrivalDate the airrivalDate to set
     */
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * @return the departureDate
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

}
