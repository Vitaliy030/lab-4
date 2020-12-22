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

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Baggage> getBaggages() {
        return baggages;
    }

    public void setBaggages(List<Baggage> baggages) {
        this.baggages = baggages;
    }

    public String getPlaceOfDeparture() {
        return placeOfDeparture;
    }

    public void setPlaceOfDeparture(String placeOfDeparture) {
        this.placeOfDeparture = placeOfDeparture;
    }

    public String getPlaceOfArrival() {
        return placeOfArrival;
    }

    public void setPlaceOfArrival(String placeOfArrival) {
        this.placeOfArrival = placeOfArrival;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public LocalDateTime getTakeoffTime() {
        return takeoffTime;
    }

    public void setTakeoffTime(LocalDateTime takeoffTime) {
        this.takeoffTime = takeoffTime;
    }

    public LocalDateTime getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(LocalDateTime boardingTime) {
        this.boardingTime = boardingTime;
    }


    public Ticket() {
    }

    public Ticket(Long id, String flight, double price, User user, List<Baggage> baggages,
                  String placeOfDeparture, String placeOfArrival, String seat,
                  LocalDateTime takeoffTime, LocalDateTime boardingTime) {
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
