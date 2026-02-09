package com.codegnan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codegnan.exception.FlightNotFoundException;
import com.codegnan.model.Flight;
import com.codegnan.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService{

	private FlightRepository repository;
	
	
	public FlightServiceImpl(FlightRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Flight addFlight(Flight flight) {
		return repository.save(flight);
	}

	@Override
	public Flight getFlightById(Integer id) {
		return repository.findById(id)
				.orElseThrow(()-> new FlightNotFoundException("Flight not found with id: "+id));
	}

	@Override
	public List<Flight> getAllFlights() {
		return repository.findAll();
	}

	@Override
	public Flight updateFlight(Integer id, Flight flight) {
		Flight dbFlight = getFlightById(id);
		dbFlight.setAirline(flight.getAirline());
		dbFlight.setSource(flight.getSource());
		dbFlight.setDestination(flight.getDestination());
		dbFlight.setDepartureTime(flight.getDepartureTime());
		dbFlight.setArrivalTime(flight.getArrivalTime());
		dbFlight.setPrice(flight.getPrice());
		dbFlight.setSeatsAvailable(flight.getSeatsAvailable());
		dbFlight.setStatus(flight.getStatus());
		
		return repository.save(dbFlight);
	}

	@Override
	public void delteFlight(Integer id) {
		Flight flight = getFlightById(id);
		repository.delete(flight);
	}

}
