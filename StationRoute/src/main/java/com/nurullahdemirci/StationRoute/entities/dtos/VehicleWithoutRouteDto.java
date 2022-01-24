package com.nurullahdemirci.StationRoute.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleWithoutRouteDto {
	
	Integer id;
	
	String plate;
	
	String name;

}
