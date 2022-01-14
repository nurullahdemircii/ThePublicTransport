package com.nurullahdemirci.StationRoute.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nurullahdemirci.StationRoute.entities.concretes.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, Integer>{

}
