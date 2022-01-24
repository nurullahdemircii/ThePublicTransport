package com.nurullahdemirci.StationRoute.business.concretes;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.StationRoute.business.abstracts.VehicleService;
import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.SuccessResult;
import com.nurullahdemirci.StationRoute.dataAccess.abstracts.VehicleDao;
import com.nurullahdemirci.StationRoute.entities.concretes.Vehicle;
import com.nurullahdemirci.StationRoute.entities.dtos.VehicleWithoutRouteDto;

@Service
public class VehicleManager implements VehicleService {

	private VehicleDao vehicleDao;
	
	@Autowired
	public VehicleManager(VehicleDao vehicleDao) {
		super();
		this.vehicleDao = vehicleDao;
	}

	@Override
	public Result add(Vehicle vehicle) {
		this.vehicleDao.save(vehicle);
		return new SuccessResult("The vehicle has been added.");
	}

	@Override
	public Result update(Integer vehicleId, VehicleWithoutRouteDto vehicleWithoutRouteDto) {
		Vehicle vehicle = this.vehicleDao.findById(vehicleId).orElseThrow(EntityNotFoundException::new);
		vehicle.setName(vehicleWithoutRouteDto.getName());
		vehicle.setPlate(vehicleWithoutRouteDto.getPlate());
		this.vehicleDao.save(vehicle);
		return new SuccessResult("The vehicle has been updated.");
	}

	@Override
	public Result delete(Integer vehicleId) {
		this.vehicleDao.deleteById(vehicleId);
		return new SuccessResult("The vehicle has been deleted.");
	}

	@Override
	public DataResult<Vehicle> getById(Integer vehicleId) {
		return new SuccessDataResult<Vehicle>(this.vehicleDao.getById(vehicleId), "The vehicle has been listed according as vehicleId.");
	}

	@Override
	public DataResult<List<Vehicle>> getAll() {
		return new SuccessDataResult<List<Vehicle>>(this.vehicleDao.findAll(), "The vehicles has been listed.");
	}

	@Override
	public Result updateRoute(Integer vehicleId, Integer routeId) {
		this.vehicleDao.updateRoute(vehicleId, routeId);
		return new SuccessResult("The vehicle has been updated according as routeId..");
	}

}
