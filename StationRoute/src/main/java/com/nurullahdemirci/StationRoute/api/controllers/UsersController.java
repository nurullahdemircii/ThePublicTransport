package com.nurullahdemirci.StationRoute.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nurullahdemirci.StationRoute.business.abstracts.UserService;
import com.nurullahdemirci.StationRoute.core.entities.User;
import com.nurullahdemirci.StationRoute.core.utilities.results.ErrorDataResult;
import com.nurullahdemirci.StationRoute.entities.dtos.UpdateUserDetailsDto;
import com.nurullahdemirci.StationRoute.entities.dtos.UpdateUserPasswordDto;



@RestController
@RequestMapping("api")
public class UsersController {
	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping(value="/users/create")
	public ResponseEntity<?> create(@Valid @RequestBody User user){
		return ResponseEntity.ok(this.userService.create(user));
	}
	
	@PutMapping(value="/users/update-details/{id}")
	public ResponseEntity<?> updateDetails(@PathVariable Integer id, @Valid @RequestBody UpdateUserDetailsDto updateUserDetailsDto){
		return ResponseEntity.ok(this.userService.updateUserDetails(id, updateUserDetailsDto));
	}
	
	@PutMapping(value="/users/update-password/{id}")
	public ResponseEntity<?> updatePassword(@PathVariable Integer id, @Valid @RequestBody UpdateUserPasswordDto updateUserPasswordDto){
		return ResponseEntity.ok(this.userService.updateUserPassword(id, updateUserPasswordDto));
	}
	
	@DeleteMapping(value="/users/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		return ResponseEntity.ok(this.userService.delete(id));
	}
	
	@GetMapping(value="/users")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.userService.getAll());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>(); // Map<keyValue, errorMessage>
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doðrulama Hatalarý");
		
		return errors;
	}
	

}
