package com.yordankarabelyov.Airlines.Management.System.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Airline {
    @Id
    @GeneratedValue
    private int airlineId;
    private String name;

    public Airline() {
    }

    public void setAirlineId(int id) {
        this.airlineId = id;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airline(String name) {
        this.name = name;
    }
}
