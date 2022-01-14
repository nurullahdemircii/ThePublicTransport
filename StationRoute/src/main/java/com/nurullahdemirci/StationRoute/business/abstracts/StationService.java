package com.nurullahdemirci.StationRoute.business.abstracts;

import java.util.List;

import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.entities.concretes.Station;

public interface StationService {
	
	Result add(Station station);
	
	Result update(Station station);
	
	Result delete(Station station);
	
	DataResult<Station> getById(Integer station_id);
	
	DataResult<List<Station>> getAll();
	
}
