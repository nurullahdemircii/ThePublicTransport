package com.nurullahdemirci.StationRoute.business.abstracts;

import java.util.List;

import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.entities.concretes.Station;
import com.nurullahdemirci.StationRoute.entities.dtos.StationWithoutRouteDto;

public interface StationService {
	
	Result add(Station station);
	
	Result update(Integer stationId, StationWithoutRouteDto stationWithoutRouteDto);
	
	Result delete(Integer stationId);
	
	DataResult<Station> getById(Integer stationId);
	
	DataResult<List<Station>> getAll();
	
}
