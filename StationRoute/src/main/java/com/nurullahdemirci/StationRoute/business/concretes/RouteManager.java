package com.nurullahdemirci.StationRoute.business.concretes;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurullahdemirci.StationRoute.business.abstracts.RouteService;
import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.ErrorResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.core.utilities.results.SuccessDataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.SuccessResult;
import com.nurullahdemirci.StationRoute.dataAccess.abstracts.RouteDao;
import com.nurullahdemirci.StationRoute.dataAccess.abstracts.RouteStationDao;
import com.nurullahdemirci.StationRoute.entities.concretes.Route;
import com.nurullahdemirci.StationRoute.entities.concretes.RouteStation;
import com.nurullahdemirci.StationRoute.entities.concretes.Station;
import com.nurullahdemirci.StationRoute.entities.dtos.RouteCreateDto;
import com.nurullahdemirci.StationRoute.entities.dtos.RouteWithStationDto;
import com.nurullahdemirci.StationRoute.entities.dtos.RouteWithoutStationDto;

@Service
public class RouteManager implements RouteService {

	private RouteDao routeDao;
	private RouteStationDao routeStationDao;
	
	@Autowired
	public RouteManager(RouteDao routeDao, RouteStationDao routeStationDao) {
		super();
		this.routeDao = routeDao;
		this.routeStationDao = routeStationDao;
	}
	
	@Override
	public Result add(RouteCreateDto routeCreateDto) {
		//this.routeDao.save(route);
		Route route = new Route();
		route.setName(routeCreateDto.getRouteName());
		route.setDescription(routeCreateDto.getRouteDescription());
		if(routeCreateDto.getStations().size() > 1) {
			
			this.routeDao.save(route);
			int k = 0;
			
			for(Station station  : routeCreateDto.getStations()){
				k = 0;
				RouteStation routeStation = new RouteStation();
				routeStation.setRoute(route);
				routeStation.setSequenceNumber(routeCreateDto.getSequenceNumber().get(k));
				routeStation.setStation(station);
				this.routeStationDao.save(routeStation);
				k++;
			}
			return new SuccessResult("The route has been added.");
		}
		else {
			return new ErrorResult("Must have at least two station!");
		}
	}
	
	@Override
	public Result update(Integer routeId, RouteWithoutStationDto routeWithoutStationDto) {
		Route route = this.routeDao.findById(routeId).orElseThrow(EntityNotFoundException::new);
		route.setName(routeWithoutStationDto.getName());
		route.setDescription(routeWithoutStationDto.getDescription());
		this.routeDao.save(route);
		return new SuccessResult("The route has been updated.");
	}

	@Override
	public Result delete(Integer routeId) {
		this.routeDao.deleteById(routeId);
		return new SuccessResult("The route has been deleted.");
	}

	@Override
	public DataResult<Route> getById(Integer routeId) {
		return new SuccessDataResult<Route>(this.routeDao.getById(routeId), "The route has been listed.");
	}

	@Override
	public DataResult<List<Route>> getAll() {
		return new SuccessDataResult<List<Route>>(this.routeDao.findAll(), "The routes have been listed.");
	}

	@Override
	public DataResult<List<RouteWithStationDto>> getRouteWithStations() {
		return new SuccessDataResult<List<RouteWithStationDto>>(this.routeDao.getRouteWithStations(), "");
	}
}
