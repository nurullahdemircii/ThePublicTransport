package com.nurullahdemirci.StationRoute.entities.dtos;

import java.util.List;

import com.nurullahdemirci.StationRoute.entities.concretes.Station;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteCreateDto {
	
	private Integer routeId;
	
	private String routeName;
	
	private String routeDescription;
	
	private List<Integer> sequenceNumber;
	
	private List<Station> stations;

}
