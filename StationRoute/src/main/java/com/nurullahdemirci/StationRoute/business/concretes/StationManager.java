package com.nurullahdemirci.StationRoute.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.StationRoute.business.abstracts.StationService;
import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.SuccessResult;
import com.nurullahdemirci.StationRoute.dataAccess.abstracts.StationDao;
import com.nurullahdemirci.StationRoute.entities.concretes.Station;

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
		return new SuccessResult("Yönetici Eklendi.");
	}	

	@Override
	public Result update(Station station) {
		this.stationDao.save(station);
		return new SuccessResult("Yönetici Bilgileri Güncellendi!");
	}

	@Override
	public Result delete(Station station) {
		this.stationDao.delete(station);
		return new SuccessResult("Yönetici Silindi.");
	}

	@Override
	public DataResult<Station> getById(Integer stationId) {
		return new SuccessDataResult<Station>(this.stationDao.getById(stationId), "Yönetici Listelendi.");
	}

	@Override
	public DataResult<List<Station>> getAll() {
		return new SuccessDataResult<List<Station>>(this.stationDao.findAll(), "Yöneticiler Listelendi.");
	}

}
