package com.nurullahdemirci.StationRoute.business.abstracts;

import java.util.List;

import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.entities.concretes.Vehicle;

public interface VehicleService {
	
	Result add(Vehicle vehicle);
	
	Result update(Integer id, Vehicle vehicle);
	
	Result delete(Integer id);
	
	DataResult<Vehicle> getById(Integer id);
	
	DataResult<List<Vehicle>> getAll();
	
}
