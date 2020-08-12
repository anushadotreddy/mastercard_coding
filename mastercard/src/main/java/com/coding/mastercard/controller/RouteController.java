package com.coding.mastercard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding.mastercard.domain.Route;
import com.coding.mastercard.handler.RouteService;

/**
 * 
 * This controller handles the /connected endpoint to determine if two routes
 * are connected.
 * 
 * @author sri anusha
 *
 */
@RestController
public class RouteController {

	@Autowired
	private RouteService routeService;

	/**
	 * endpoint to determine if two routes are connected returns 'yes' if two cities
	 * are connected, or returns 'no'.
	 * 
	 * @param origin
	 * @param destination
	 * @return String
	 */
	@RequestMapping(value = "/connected", method = RequestMethod.GET)
	public String connected(@RequestParam("origin") String origin, @RequestParam("destination") String destination) {
		String response = "no";
		Route route = new Route(origin, destination);
		response = routeService.isValidRoute(route);
		return response;
	}

}
