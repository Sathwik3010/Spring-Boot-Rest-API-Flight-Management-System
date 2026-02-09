package com.codegnan.service;

import java.util.List;

import com.codegnan.model.Flight;

public interface FlightService {
	Flight addFlight(Flight flight);
	
	Flight getFlightById(Integer id);
	
	List<Flight> getAllFlights();
	
	Flight updateFlight(Integer id, Flight flight);
	
	void delteFlight(Integer id);
}
