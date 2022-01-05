package com.yordankarabelyov.Airlines.Management.System.services;

import com.yordankarabelyov.Airlines.Management.System.entities.Flight;
import com.yordankarabelyov.Airlines.Management.System.entities.Passenger;
import com.yordankarabelyov.Airlines.Management.System.entities.Plane;
import com.yordankarabelyov.Airlines.Management.System.exceptions.PlaneCapacityExceededException;
import com.yordankarabelyov.Airlines.Management.System.repository.FlightRepository;
import com.yordankarabelyov.Airlines.Management.System.responseObjects.FlightResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PlaneService planeService;

    @Autowired
    AirlineService airlineService;

    @Autowired
    AirportService airportService;

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Optional<Flight> findById(int id) {
        Optional<Flight> flight = flightRepository.findById(id);
        return flight;
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public void addPassengers(Flight flight, List<Passenger> passengers) {
        Plane plane = planeService.findById(flight.getPlaneId());
        if (flight.getPassengerList().size() + passengers.size() > plane.getNumberOfSeats()){
            throw new PlaneCapacityExceededException("Plane capacity exceeded", new Throwable());
        }
            flight.getPassengerList().addAll(passengers);
    }

    @Override
    public List<FlightResponse> searchFlights(int departureAirportId, int arrivalAirportId, LocalDate fromDate, LocalDate toDate) {
        List<Flight> flightsResult = flightRepository.getFlights(departureAirportId, arrivalAirportId, fromDate, toDate);
        List<FlightResponse> flights = new ArrayList<>();
        for (Flight flight : flightsResult
        ) {
            FlightResponse flightResponse = mapFlightResponse(flight);
            flights.add(flightResponse);
        }
        return flights;
    }

    private FlightResponse mapFlightResponse(Flight flight) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        FlightResponse flightResponse = new FlightResponse();
        flightResponse.setFlightNumber(flight.getFlightNumber());
        flightResponse.setDepartureTime(flight.getDepartureTime().format(formatter));
        flightResponse.setArrivalTime(flight.getArrivalTime().format(formatter));
        flightResponse.setDepartureAirport(airportService.findById(flight.getDepartureAirportId()).getLocation());
        flightResponse.setArrivalAirport(airportService.findById(flight.getArrivalAirportId()).getLocation());
        return flightResponse;
    }
}
