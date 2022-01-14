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
import com.nurullahdemirci.StationRoute.dataAccess.abstracts.RouteDao;
import com.nurullahdemirci.StationRoute.dataAccess.abstracts.VehicleDao;
import com.nurullahdemirci.StationRoute.entities.concretes.Vehicle;

@Service
public class VehicleManager implements VehicleService {

	private VehicleDao vehicleDao;
	private RouteDao routeDao;
	
	@Autowired
	public VehicleManager(VehicleDao vehicleDao, RouteDao routeDao) {
		super();
		this.vehicleDao = vehicleDao;
		this.routeDao = routeDao;
	}

	@Override
	public Result add(Vehicle vehicle) {
		this.vehicleDao.save(vehicle);
		return new SuccessResult("Araç Eklendi.");
	}

	@Override
	public Result update(Integer id, Vehicle vehicle) {
		Vehicle updateVehicle = this.vehicleDao.findById(id).orElseThrow(EntityNotFoundException::new);
		updateVehicle.setName(vehicle.getName());
		updateVehicle.setPlate(vehicle.getPlate());
		updateVehicle.setRoute(vehicle.getRoute());
		this.vehicleDao.save(updateVehicle);
		return new SuccessResult("Araç Bilgileri Güncellendi!");
	}

	@Override
	public Result delete(Integer id) {
		this.vehicleDao.deleteById(id);
		return new SuccessResult("Yönetici Silindi.");
	}

	@Override
	public DataResult<Vehicle> getById(Integer vehicleId) {
		return new SuccessDataResult<Vehicle>(this.vehicleDao.getById(vehicleId), "Yönetici Listelendi.");
	}

	@Override
	public DataResult<List<Vehicle>> getAll() {
		return new SuccessDataResult<List<Vehicle>>(this.vehicleDao.findAll(), "Yöneticiler Listelendi.");
	}

}
