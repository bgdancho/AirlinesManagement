package com.yordankarabelyov.Airlines.Management.System.repository;

import com.yordankarabelyov.Airlines.Management.System.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
