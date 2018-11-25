package com.zycus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.entity.Flight;
import com.zycus.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;

	@RequestMapping(value = "/flight/all", method = RequestMethod.GET, produces = "application/json")
	public List<Flight> getAll() {
		return flightService.getAvailableFlights();
	}

	@RequestMapping(value = "/flight/{flightNo}", method = RequestMethod.GET, produces = "application/json")
	public Flight get(@PathVariable("flightNo") String flightNo) {
		return flightService.getFlight(flightNo);
	}

	@RequestMapping(value = "/flight/add", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
	public String add(@RequestBody Flight flight) {
		flightService.addNewFlight(flight);
		return "Flight record created successfully!";
	}

}
