package com.springbootproject.entity;

import java.time.LocalDate;
import java.util.List;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birth;

    //todo add username and password

    private List<Ticket> tickets;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(final LocalDate birth) {
        this.birth = birth;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(final List<Ticket> tickets) {
        this.tickets = tickets;
    }


    public User() {
    }

    public User(final Long id, final String firstName, final String lastName, final LocalDate birth, final List<Ticket> tickets) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.tickets = tickets;
    }
}
