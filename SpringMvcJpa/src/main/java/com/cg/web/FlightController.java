package com.cg.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.entity.Flight;
import com.cg.exception.InvalidFlightException;
import com.cg.service.FlightService;

@Controller
public class FlightController {

	@Autowired
	private FlightService service;
	
	@RequestMapping("/addFlight.do")
	public String addFlight(Flight flight, Map model) {
		int id = service.addFlight(flight);
		model.put("message", "Flight added with Id: " + id);
		return "addFlight";
	}
	
	@RequestMapping("/fetchFlight.do")
	public String fetchFlight(int id, Map model) throws InvalidFlightException {
		Flight flight = service.getFlight(id);
		model.put("flight", flight);
		return "fetchFlight";
	}
	
//	@RequestMapping("/getList.do")
//	public List<Flight> getList(Map model){
//		List<Flight> flights = service.getList();
//		for (Flight flight : flights) {
//			model.put("flight", flight);
//		}
//		return flights;
//	}
}
