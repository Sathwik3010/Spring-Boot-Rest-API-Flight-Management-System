package com.codegnan.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Flight {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String airline;
	private String source;
	private String destination;
	
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	
	private double price;
	private int seatsAvailable;
	
	@Enumerated(EnumType.STRING)
	private FlightStatus status;

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public FlightStatus getStatus() {
		return status;
	}

	public void setStatus(FlightStatus status) {
		this.status = status;
	}


	public Flight(String airline, String source, String destination, LocalDateTime departureTime,
			LocalDateTime arrivalTime, double price, int seatsAvailable, FlightStatus status) {
		super();
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
		this.seatsAvailable = seatsAvailable;
		this.status = status;
	}

	public Flight() {
		super();
	}
	
	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", " + source + " -> " + destination + ", price=" + price
				+ ", seats=" + seatsAvailable + ", status=" + status + "]";
	}
}
