package com.nurullahdemirci.StationRoute.business.concretes;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.StationRoute.business.abstracts.StationService;
import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.SuccessResult;
import com.nurullahdemirci.StationRoute.dataAccess.abstracts.StationDao;
import com.nurullahdemirci.StationRoute.entities.concretes.Station;
import com.nurullahdemirci.StationRoute.entities.dtos.StationWithoutRouteDto;

@Service
public class StationManager implements StationService {
	
	private StationDao stationDao;
	
	@Autowired
	public StationManager(StationDao stationDao) {
		super();
		this.stationDao = stationDao;
	}

	@Override
	public Result add(Station station) {
		this.stationDao.save(station);
		return new SuccessResult("The station has been added.");
	}	

	@Override
	public Result update(Integer stationId, StationWithoutRouteDto stationWithoutRouteDto) {
		Station station = this.stationDao.findById(stationId).orElseThrow(EntityNotFoundException::new);
		station.setName(stationWithoutRouteDto.getName());
		station.setLocation(stationWithoutRouteDto.getLocation());
		this.stationDao.save(station);
		return new SuccessResult("The station datas have been updated.");
	}

	@Override
	public Result delete(Integer stationId) {
		this.stationDao.deleteById(stationId);
		return new SuccessResult("The station has been deleted.");
	}

	@Override
	public DataResult<Station> getById(Integer stationId) {
		return new SuccessDataResult<Station>(this.stationDao.getById(stationId), "The station has been listed.");
	}

	@Override
	public DataResult<List<Station>> getAll() {
		return new SuccessDataResult<List<Station>>(this.stationDao.findAll(), "The stations have been listed.");
	}

}
