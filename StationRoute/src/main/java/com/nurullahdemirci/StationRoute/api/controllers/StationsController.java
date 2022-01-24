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

import com.nurullahdemirci.StationRoute.business.abstracts.StationService;
import com.nurullahdemirci.StationRoute.core.utilities.results.ErrorDataResult;
import com.nurullahdemirci.StationRoute.entities.concretes.Station;
import com.nurullahdemirci.StationRoute.entities.dtos.StationWithoutRouteDto;

@RestController
@RequestMapping("/api")
public class StationsController {

	private StationService stationService;

	@Autowired
	public StationsController(StationService stationService) {
		super();
		this.stationService = stationService;
	}
	
	@PostMapping(value="/stations/add")
	public ResponseEntity<?> add(@Valid @RequestBody Station station){
		return ResponseEntity.ok(this.stationService.add(station));
	}
	
	@PutMapping(value="/stations/update/{vehicleId}")
	public ResponseEntity<?> update(@PathVariable Integer stationId, @Valid @RequestBody StationWithoutRouteDto stationWithoutRouteDto){
		return ResponseEntity.ok(this.stationService.update(stationId, stationWithoutRouteDto));
	}
	
	@DeleteMapping(value="/stations/delete/{stationId}")
	public ResponseEntity<?> delete(@PathVariable Integer stationId){
		return ResponseEntity.ok(this.stationService.delete(stationId));
	}
	
	@GetMapping(value="/stations/{stationId}")
	public ResponseEntity<?> getById(Integer stationId){
		return ResponseEntity.ok(this.stationService.getById(stationId));
	}
	
	@GetMapping(value="/stations")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.stationService.getAll());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation errors.");
		
		return errors;
	}
	
}
