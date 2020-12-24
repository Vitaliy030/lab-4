package com.springbootproject.dto;

import javax.validation.constraints.Min;

public class BaggageDTO {
    private Long id;
    private String userFirstName;
    private String userLastName;

    @Min(value = 1)
    private double weight;

    @Min(value = 1)
    private double size;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
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


    public BaggageDTO() {
    }

    public BaggageDTO(final Long id, final String userFirstName, final String userLastName,
                      final double weight, final double size) {
        this.id = id;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.weight = weight;
        this.size = size;
    }
}
