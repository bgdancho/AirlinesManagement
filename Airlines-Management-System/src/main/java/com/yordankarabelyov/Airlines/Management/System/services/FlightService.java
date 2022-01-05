package com.yordankarabelyov.Airlines.Management.System.services;

import com.yordankarabelyov.Airlines.Management.System.entities.Flight;
import com.yordankarabelyov.Airlines.Management.System.entities.Passenger;
import com.yordankarabelyov.Airlines.Management.System.responseObjects.FlightResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface FlightService {
    Flight save(Flight flight);

    Optional<Flight> findById(int id);

    List<Flight> findAll();

    void addPassengers(Flight flight, List<Passenger> passengers);

    List<FlightResponse> searchFlights(int depId, int arrId, LocalDate fromDate, LocalDate toDate);
}
