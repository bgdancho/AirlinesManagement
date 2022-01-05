package com.yordankarabelyov.Airlines.Management.System.services;

import com.yordankarabelyov.Airlines.Management.System.entities.Airline;

public interface AirlineService {
    Airline findAirlineById(int id);
    Airline save(Airline airline);
}
