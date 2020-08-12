package com.coding.mastercard.handler;

import org.springframework.stereotype.Component;

@Component
public class RouteHandler {
	
	
	public String isValidRoute(String origin, String destination) {
		
		String queryRoute = origin+","+destination;
		
		
		
		return "no";
	}

}
