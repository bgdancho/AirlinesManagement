package com.yordankarabelyov.Airlines.Management.System.controllers;

import com.yordankarabelyov.Airlines.Management.System.entities.Flight;
import com.yordankarabelyov.Airlines.Management.System.entities.Passenger;
import com.yordankarabelyov.Airlines.Management.System.exceptions.PlaneCapacityExceededException;
import com.yordankarabelyov.Airlines.Management.System.responseObjects.FlightResponse;
import com.yordankarabelyov.Airlines.Management.System.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController("/")
public class FlightController {
    @Autowired
    FlightService flightService;

    @PostMapping("/flights")
    public void bookFlight(@PathVariable("{id}") int id, @RequestBody List<Passenger> passengerList) {
        Optional<Flight> flight = flightService.findById(id);
        if (flight.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");
        }
        try {
            flightService.addPassengers(flight.get(), passengerList);
        } catch (PlaneCapacityExceededException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/flights")
    public List<FlightResponse> getFlights(@RequestParam("fromDate") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate fromDate,
                                           @RequestParam("toDate") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate toDate,
                                           @RequestParam int startAirportId,
                                           @RequestParam int endAirportId) {
        return flightService.searchFlights(startAirportId, endAirportId, fromDate, toDate);
    }
}
