package com.nurullahdemirci.StationRoute.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteWithStationDto {
	
	private Integer id;
	
	private String routeName;
	
	private String routeDescription;
	
	private String stationName;
	
	private String stationLocation;

}
