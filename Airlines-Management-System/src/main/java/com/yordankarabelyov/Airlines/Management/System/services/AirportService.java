package com.yordankarabelyov.Airlines.Management.System.services;

import com.yordankarabelyov.Airlines.Management.System.entities.Airport;

public interface AirportService {
    Airport findById(int id);
}
