package com.nurullahdemirci.StationRoute.business.abstracts;

import java.util.List;

import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.entities.concretes.Route;
import com.nurullahdemirci.StationRoute.entities.dtos.RouteCreateDto;
import com.nurullahdemirci.StationRoute.entities.dtos.RouteWithStationDto;
import com.nurullahdemirci.StationRoute.entities.dtos.RouteWithoutStationDto;

public interface RouteService {
	
	Result add(RouteCreateDto routeCreateDto);
	
	Result update(Integer routeId, RouteWithoutStationDto routeWithoutStationDto);
	
	Result delete(Integer routeId);
	
	DataResult<Route> getById(Integer routeId);
	
	DataResult<List<Route>> getAll();
	
	DataResult<List<RouteWithStationDto>> getRouteWithStations(); 
	
}
