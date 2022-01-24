package com.nurullahdemirci.StationRoute.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteWithoutStationDto {
	
	private Integer id;

	private String name;
	
	private String description;

}
