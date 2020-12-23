package com.springbootproject.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Ticket {
    private Long id;
    private String flight;
    private double price;

    private User user;
    private List<Baggage> baggages;

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

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public List<Baggage> getBaggages() {
        return baggages;
    }

    public void setBaggages(final List<Baggage> baggages) {
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


    public Ticket() {
    }

    public Ticket(final Long id, final String flight, final double price, final User user, final List<Baggage> baggages,
                  final String placeOfDeparture, final String placeOfArrival, final String seat,
                  final LocalDateTime takeoffTime, final LocalDateTime boardingTime) {
        this.id = id;
        this.flight = flight;
        this.price = price;
        this.user = user;
        this.baggages = baggages;
        this.placeOfDeparture = placeOfDeparture;
        this.placeOfArrival = placeOfArrival;
        this.seat = seat;
        this.takeoffTime = takeoffTime;
        this.boardingTime = boardingTime;
    }
}
