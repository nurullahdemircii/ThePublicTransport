package com.nurullahdemirci.StationRoute.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserPasswordDto {
	
	Integer id;
	
	String password;
	
	String passwordRepeat;

}
