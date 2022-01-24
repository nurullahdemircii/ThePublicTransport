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

import com.nurullahdemirci.StationRoute.business.abstracts.RouteService;
import com.nurullahdemirci.StationRoute.core.utilities.results.ErrorDataResult;
import com.nurullahdemirci.StationRoute.entities.dtos.RouteCreateDto;
import com.nurullahdemirci.StationRoute.entities.dtos.RouteWithoutStationDto;

@RestController
@RequestMapping("api")
public class RoutesController {
	
	private RouteService routeService;

	@Autowired
	public RoutesController(RouteService routeService) {
		super();
		this.routeService = routeService;
	}
	
	@PostMapping(value="/routes/add")
	public ResponseEntity<?> add(@Valid @RequestBody RouteCreateDto routeCreateDto){
		return ResponseEntity.ok(this.routeService.add(routeCreateDto));
	} 
	
	@PutMapping(value="/routes/update/{routeId}")
	public ResponseEntity<?> update(@PathVariable Integer routeId, @Valid @RequestBody RouteWithoutStationDto routeWithoutStationDto){
		return ResponseEntity.ok(this.routeService.update(routeId, routeWithoutStationDto));
	}
	
	@DeleteMapping(value="/routes/delete/{routeId}")
	public ResponseEntity<?> delete(@PathVariable Integer routeId){
		return ResponseEntity.ok(this.routeService.delete(routeId));
	}
	
	@GetMapping(value="/routes/{routeId}")
	public ResponseEntity<?> getById(@PathVariable Integer routeId){
		return ResponseEntity.ok(this.routeService.getById(routeId));
	}
	
	@GetMapping(value="/routes")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.routeService.getAll());
	}
	
	@GetMapping(value="/routes-all")
	public ResponseEntity<?> getByIdRouteWithStations(){
		return ResponseEntity.ok(this.routeService.getRouteWithStations());
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
