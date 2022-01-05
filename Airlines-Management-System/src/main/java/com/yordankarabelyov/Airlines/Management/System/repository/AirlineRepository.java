package com.yordankarabelyov.Airlines.Management.System.repository;

import com.yordankarabelyov.Airlines.Management.System.entities.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer > {
    boolean existsAirlineByName(String name);
}
