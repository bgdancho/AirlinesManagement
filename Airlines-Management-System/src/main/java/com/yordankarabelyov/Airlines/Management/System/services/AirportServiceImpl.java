package com.yordankarabelyov.Airlines.Management.System.services;

import com.yordankarabelyov.Airlines.Management.System.entities.Airport;
import com.yordankarabelyov.Airlines.Management.System.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {
    @Autowired
    AirportRepository airportRepository;

    @Override
    public Airport findById(int id) {
        return airportRepository.findById(id);
    }
}
