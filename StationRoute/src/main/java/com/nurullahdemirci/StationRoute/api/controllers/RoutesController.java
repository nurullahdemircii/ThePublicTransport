package com.nurullahdemirci.StationRoute.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nurullahdemirci.StationRoute.business.abstracts.RouteService;

@RestController
@RequestMapping("api")
public class RoutesController {
	
	private RouteService routeService;

	@Autowired
	public RoutesController(RouteService routeService) {
		super();
		this.routeService = routeService;
	}
	
	@GetMapping(value="/routes")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.routeService.getAll());
	}

}
