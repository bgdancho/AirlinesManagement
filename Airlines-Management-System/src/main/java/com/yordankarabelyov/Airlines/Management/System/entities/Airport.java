package com.yordankarabelyov.Airlines.Management.System.entities;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport {
    @Id
    private int airportId;
    private String location;
    private String name;

    public Airport(int airportId, String location, String name) {
        this.airportId = airportId;
        this.location = location;
        this.name = name;
    }

    public Airport() {
    }

    public void setAirportId(int id) {
        this.airportId = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAirportId() {
        return airportId;
    }
}
