package com.yordankarabelyov.Airlines.Management.System.repository;

import com.yordankarabelyov.Airlines.Management.System.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {
    Airport findById(int id);
}
