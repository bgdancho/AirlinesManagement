package com.yordankarabelyov.Airlines.Management.System.services;

import com.yordankarabelyov.Airlines.Management.System.entities.Plane;
import com.yordankarabelyov.Airlines.Management.System.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneServiceImpl implements PlaneService {
    @Autowired
    PlaneRepository planeRepository;

    @Override
    public Plane save(Plane plane) {
        return planeRepository.save(plane);
    }

    @Override
    public Plane findById(int id) {
        return planeRepository.findById(id).get();
    }
}
