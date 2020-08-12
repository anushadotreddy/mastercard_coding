package com.coding.mastercard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding.mastercard.handler.RouteHandler;

@RestController
public class RouteController {
	
	@Autowired
	private RouteHandler routeHandler;

	
	@RequestMapping(value = "/connected", method = RequestMethod.GET)
	public String sayHello(@RequestParam("origin") String origin, @RequestParam("destination") String destination) {
		String response = "no";
		response = routeHandler.isValidRoute(origin, destination);
		return "hello";
	}
	
	

}
