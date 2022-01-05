package com.yordankarabelyov.Airlines.Management.System.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private int flightId;
    private String flightNumber;
    private int departureAirportId;
    private int arrivalAirportId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String captainName;
    private String secondPilotName;
    private int planeId;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name = "flight_passenger", joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id"))
    private List<Passenger> passengerList;

    public int getFlightId() {
        return flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getDepartureAirportId() {
        return departureAirportId;
    }

    public void setDepartureAirportId(int departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    public int getArrivalAirportId() {
        return arrivalAirportId;
    }

    public void setArrivalAirportId(int arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public String getSecondPilotName() {
        return secondPilotName;
    }

    public void setSecondPilotName(String secondPilotName) {
        this.secondPilotName = secondPilotName;
    }

    public int getPlaneId() {
        return planeId;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public Flight() {
        passengerList = new ArrayList<>();
    }

    public Flight(String flightNumber, int planeId, int departureAirportId, int arrivalAirportId, LocalDateTime departureTime, LocalDateTime arrivalTime, String captainName, String secondPilotName) {
        this.flightNumber = flightNumber;
        this.planeId = planeId;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.captainName = captainName;
        this.secondPilotName = secondPilotName;
        passengerList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + flightId +
                ", flightNumber='" + flightNumber + '\'' +
                ", airplaneId=" + planeId +
                ", departureAirportId=" + departureAirportId +
                ", arrivalAirportId=" + arrivalAirportId +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", captainName='" + captainName + '\'' +
                ", secondPilotName='" + secondPilotName + '\'' +
                '}';
    }
}
