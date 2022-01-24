package com.nurullahdemirci.StationRoute.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {

	private Integer id;
	
	private String email;
	
	private String password;
	
}
