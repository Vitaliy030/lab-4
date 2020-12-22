package com.springbootproject.entity;

public class Baggage {
    private Long id;
    private User user;
    private double weight;
    private double size;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(final double weight) {
        this.weight = weight;
    }

    public double getSize() {
        return size;
    }

    public void setSize(final double size) {
        this.size = size;
    }


    public Baggage() {
    }

    public Baggage(final Long id, final User user, final double weight, final double size) {
        this.id = id;
        this.user = user;
        this.weight = weight;
        this.size = size;
    }
}
