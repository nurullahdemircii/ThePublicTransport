package com.nurullahdemirci.StationRoute.business.abstracts;

import java.util.List;

import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.entities.concretes.Vehicle;
import com.nurullahdemirci.StationRoute.entities.dtos.VehicleWithoutRouteDto;

public interface VehicleService {
	
	Result add(Vehicle vehicle);
	
	Result update(Integer vehicleId, VehicleWithoutRouteDto vehicleWithoutRouteDto);
	
	Result delete(Integer vehicleId);
	
	DataResult<Vehicle> getById(Integer vehicleId);
	
	DataResult<List<Vehicle>> getAll();
	
	Result updateRoute(Integer vehicleId, Integer routeId);
	
}
