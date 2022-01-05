package com.yordankarabelyov.Airlines.Management.System.repository;

import com.yordankarabelyov.Airlines.Management.System.entities.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Integer> {
}
