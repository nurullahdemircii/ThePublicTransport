package com.nurullahdemirci.StationRoute.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nurullahdemirci.StationRoute.entities.concretes.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, Integer>{
	
	@Query("UPDATE Vehicle SET route.id=:routeId WHERE id=:vehicleId")
	Vehicle updateRoute(Integer vehicleId, Integer routeId);

}
