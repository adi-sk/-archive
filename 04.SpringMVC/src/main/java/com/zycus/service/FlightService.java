package com.zycus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zycus.dao.CrudRepository;
import com.zycus.entity.Flight;

//@Component
@Service //alternative for Component
public class FlightService {

	@Autowired
	private CrudRepository crudRepository;
	
	public void addNewFlight(Flight flight) {
		crudRepository.add(flight);
	}
	
	public List<Flight> getAvailableFlights() {
		return crudRepository.fetchAll(Flight.class);
	}

	public Flight getFlight(String flightNo) {
		return crudRepository.fetchById(Flight.class, flightNo);				
	}
}
