package com.nurullahdemirci.StationRoute.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nurullahdemirci.StationRoute.business.abstracts.StationService;

@RestController
@RequestMapping("/api")
public class StationsController {

	private StationService stationService;

	@Autowired
	public StationsController(StationService stationService) {
		super();
		this.stationService = stationService;
	}
	
	@GetMapping(value="/stations")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.stationService.getAll());
	}
	
}
