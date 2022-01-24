package com.nurullahdemirci.StationRoute.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nurullahdemirci.StationRoute.entities.concretes.Route;
import com.nurullahdemirci.StationRoute.entities.dtos.RouteWithStationDto;

public interface RouteDao extends JpaRepository<Route, Integer> {
	
	@Query("SELECT new com.nurullahdemirci.StationRoute.entities.dtos.RouteWithStationDto"
			+ " (r.id, r.name, r.description, s.name, s.location) "
			+ "FROM RouteStation rs "
			+ "INNER JOIN rs.route r "
			+ "INNER JOIN rs.station s")
	List<RouteWithStationDto> getRouteWithStations();

}
