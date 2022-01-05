package com.yordankarabelyov.Airlines.Management.System.entities;

import javax.persistence.*;

@Entity
public class Plane {
    @Id
    @Column(name = "plane_id")
    private int id;
    private String type;
    private int numberOfSeats;
    private int airlineId;

    public Plane(int id, String type, int seats, int airlineId) {
        this.id = id;
        this.type = type;
        this.numberOfSeats = seats;
        this.airlineId = airlineId;
    }

    public Plane() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int seats) {
        this.numberOfSeats = seats;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }
}
