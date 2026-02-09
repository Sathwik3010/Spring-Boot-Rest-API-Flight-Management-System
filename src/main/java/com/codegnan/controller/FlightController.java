package com.codegnan.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codegnan.model.Flight;
import com.codegnan.service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
	private FlightService service;

	public FlightController(FlightService service) {
		super();
		this.service = service;
	}

	// Adding Flight
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Flight addFlight(@RequestBody Flight flight) {
		return service.addFlight(flight);
	}
	
	// Get Flight by ID
	@GetMapping("/{id}")
	public Flight getFlightById(@PathVariable Integer id) {
		return service.getFlightById(id);
	}
	
	// Get All Flights
	@GetMapping
	public List<Flight> getAllFlights(){
		return service.getAllFlights();
	}
	
	// Update Flight
	@PutMapping("/{id}")
	public Flight updateFlight(@PathVariable Integer id, 
							   @RequestBody Flight flight) {
		return service.updateFlight(id, flight);
	}
	
	// Delete Flight
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteFlight(@PathVariable Integer id) {
		service.delteFlight(id);
	}
}
