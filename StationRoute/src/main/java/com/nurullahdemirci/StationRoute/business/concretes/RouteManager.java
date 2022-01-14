package com.nurullahdemirci.StationRoute.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.StationRoute.business.abstracts.RouteService;
import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.SuccessResult;
import com.nurullahdemirci.StationRoute.dataAccess.abstracts.RouteDao;
import com.nurullahdemirci.StationRoute.entities.concretes.Route;

@Service
public class RouteManager implements RouteService {

	private RouteDao routeDao;
	
	@Autowired
	public RouteManager(RouteDao routeDao) {
		super();
		this.routeDao = routeDao;
	}
	
	@Override
	public Result add(Route route) {
		this.routeDao.save(route);
		return new SuccessResult("Yönetici Eklendi.");
	}
	
	@Override
	public Result update(Route route) {
		this.routeDao.save(route);
		return new SuccessResult("Yönetici Bilgileri Güncellendi!");
	}

	@Override
	public Result delete(Route route) {
		this.routeDao.delete(route);
		return new SuccessResult("Yönetici Silindi.");
	}

	@Override
	public DataResult<Route> getById(Integer routeId) {
		return new SuccessDataResult<Route>(this.routeDao.getById(routeId), "Yönetici Listelendi.");
	}

	@Override
	public DataResult<List<Route>> getAll() {
		return new SuccessDataResult<List<Route>>(this.routeDao.findAll(), "Yöneticiler Listelendi.");
	}
}
