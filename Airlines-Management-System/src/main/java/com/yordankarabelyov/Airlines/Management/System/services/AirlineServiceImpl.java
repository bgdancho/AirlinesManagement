package com.yordankarabelyov.Airlines.Management.System.services;

import com.yordankarabelyov.Airlines.Management.System.entities.Airline;
import com.yordankarabelyov.Airlines.Management.System.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AirlineServiceImpl implements AirlineService {
    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public Airline findAirlineById(int id) {
        return null;
    }

    @Override
    public Airline save(Airline airline) {
        if (airlineRepository.findById(airline.getAirlineId()).isPresent()) {
            return airlineRepository.save(airline);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airline not found");
    }
}
