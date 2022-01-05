package com.yordankarabelyov.Airlines.Management.System.repository;

import com.yordankarabelyov.Airlines.Management.System.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    public List<Flight> findAll();

    public Flight findFlightByFlightId(int id);

    @Query(value = "SELECT * FROM flight WHERE departure_airport_id = :departureAirportId AND arrival_airport_id= :arrivalAirportId" +
            " AND departure_time >= :from AND departure_time <= :to", nativeQuery = true)
    public List<Flight> getFlights(@Param("departureAirportId") int departureAirportId,
                                   @Param("arrivalAirportId") int arrivalAirportId,
                                   @Param("from") LocalDate from,
                                    @Param("to") LocalDate to);
}
