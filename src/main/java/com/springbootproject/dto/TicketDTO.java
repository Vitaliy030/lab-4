package com.springbootproject.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TicketDTO {
    private Long id;
    private String flight;
    private double price;

    private String userFirstName;
    private String userLastName;
    private List<BaggageDTO> baggages;

    private String placeOfDeparture;
    private String placeOfArrival;

    private String seat;

    private LocalDateTime takeoffTime;
    private LocalDateTime boardingTime;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(final String flight) {
        this.flight = flight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(final String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(final String userLastName) {
        this.userLastName = userLastName;
    }

    public List<BaggageDTO> getBaggages() {
        return baggages;
    }

    public void setBaggages(final List<BaggageDTO> baggages) {
        this.baggages = baggages;
    }

    public String getPlaceOfDeparture() {
        return placeOfDeparture;
    }

    public void setPlaceOfDeparture(final String placeOfDeparture) {
        this.placeOfDeparture = placeOfDeparture;
    }

    public String getPlaceOfArrival() {
        return placeOfArrival;
    }

    public void setPlaceOfArrival(final String placeOfArrival) {
        this.placeOfArrival = placeOfArrival;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(final String seat) {
        this.seat = seat;
    }

    public LocalDateTime getTakeoffTime() {
        return takeoffTime;
    }

    public void setTakeoffTime(final LocalDateTime takeoffTime) {
        this.takeoffTime = takeoffTime;
    }

    public LocalDateTime getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(final LocalDateTime boardingTime) {
        this.boardingTime = boardingTime;
    }


    public TicketDTO() {
    }

    public TicketDTO(final Long id, final String flight, final double price,
                     final String userFirstName, final String userLastName,
                     final List<BaggageDTO> baggages, final String placeOfDeparture,
                     final String placeOfArrival, final String seat,
                     final LocalDateTime takeoffTime, final LocalDateTime boardingTime) {
        this.id = id;
        this.flight = flight;
        this.price = price;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.baggages = baggages;
        this.placeOfDeparture = placeOfDeparture;
        this.placeOfArrival = placeOfArrival;
        this.seat = seat;
        this.takeoffTime = takeoffTime;
        this.boardingTime = boardingTime;
    }
}
