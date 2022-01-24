package com.nurullahdemirci.StationRoute.business.abstracts;

import java.util.List;

import com.nurullahdemirci.StationRoute.core.entities.User;
import com.nurullahdemirci.StationRoute.core.utilities.results.DataResult;
import com.nurullahdemirci.StationRoute.core.utilities.results.Result;
import com.nurullahdemirci.StationRoute.entities.dtos.UpdateUserDetailsDto;
import com.nurullahdemirci.StationRoute.entities.dtos.UpdateUserPasswordDto;

public interface UserService {
	
	Result create(User user);
	
	Result updateUserDetails(Integer id, UpdateUserDetailsDto updateUserDetailsDto);
	
	Result updateUserPassword(Integer id, UpdateUserPasswordDto updateUserPasswordDto);
	
	Result delete(Integer id);
	
	DataResult<User> getById(Integer id);
	
	DataResult<List<User>> getAll();
	
}
