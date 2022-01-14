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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nurullahdemirci.StationRoute.business.abstracts.VehicleService;
import com.nurullahdemirci.StationRoute.core.utilities.results.ErrorDataResult;
import com.nurullahdemirci.StationRoute.entities.concretes.Vehicle;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api")
public class VehiclesController {

	private VehicleService vehicleService;

	@Autowired
	public VehiclesController(VehicleService vehicleService) {
		super();
		this.vehicleService = vehicleService;
	}
	
	@PostMapping(value="/vehicles/add")
	public ResponseEntity<?> add(@Valid  @RequestBody Vehicle vehicle){
		return ResponseEntity.ok(this.vehicleService.add(vehicle));
	}
	
	@PutMapping(value="/vehicles/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Vehicle vehicle){
		return ResponseEntity.ok(this.vehicleService.update(id, vehicle));
	}
	
	@DeleteMapping(value="/vehicles/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		return ResponseEntity.ok(this.vehicleService.delete(id));
	}
	
	@GetMapping(value="/vehicles")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.vehicleService.getAll());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>(); // Map<keyValue, errorMessage>
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Do�rulama Hatalar�");
		
		return errors;
	}
	
}
