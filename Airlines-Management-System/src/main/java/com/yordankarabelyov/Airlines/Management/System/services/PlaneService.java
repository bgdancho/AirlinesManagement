package com.yordankarabelyov.Airlines.Management.System.services;

import com.yordankarabelyov.Airlines.Management.System.entities.Plane;

public interface PlaneService {
    Plane save(Plane plane);
    Plane findById(int id);
}
