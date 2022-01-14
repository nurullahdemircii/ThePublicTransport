package com.nurullahdemirci.StationRoute.business.abstracts;

import java.util.List;

import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.entities.concretes.Route;

public interface RouteService {
	
	Result add(Route route);
	
	Result update(Route route);
	
	Result delete(Route route);
	
	DataResult<Route> getById(Integer route_id);
	
	DataResult<List<Route>> getAll();
	
}
