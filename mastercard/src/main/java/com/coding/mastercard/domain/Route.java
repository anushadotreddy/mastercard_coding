package com.coding.mastercard.domain;

/**
 * Domain class for Route with
 * Origin and destination attributes
 * @author sri anusha
 *
 */
public class Route {

	public String origin;
	public String destination;

	public Route(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}
	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
