package com.coding.mastercard.handler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.coding.mastercard.domain.Route;

/**
 * 
 * This service determines if two cities are connected.
 * 
 * @author Sri anusha
 *
 */
@Component
public class RouteService {

	private HashMap<String, String> citiesMap = new HashMap<>();

	/**
	 * returns 'yes' if two cities are connected, or returns 'no'.
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 * @return
	 */
	public String isValidRoute(Route route) {

		if (route != null && route.getOrigin() != null && route.getDestination() != null && !route.getOrigin().isBlank()
				&& !route.getDestination().isBlank()) {
			String origin = route.getOrigin();
			String destination = route.getDestination();
			try {
				File file = ResourceUtils.getFile("classpath:routes/city.txt");
				Files.lines(Paths.get(file.getPath()))
						.forEach(s -> citiesMap.put(s.split(",")[0].trim(), s.split(",")[1].trim()));

				// directly connected.
				if (isConnected(origin, destination)) {
					return "yes";
				} else {
					String layover = citiesMap.get(origin);
					if (layover != null && !layover.isEmpty()) {
						if (isConnected(origin, layover)) {
							return "yes";
						}
					}
				}
				return isValidRoute(new Route(destination, origin));
			} catch (IOException e) {

			}
		}
		return "no";
	}

	public boolean isConnected(String origin, String dest) {
		if ((citiesMap.containsKey(origin) && citiesMap.get(origin).equalsIgnoreCase(dest))
				|| (citiesMap.containsKey(dest) && citiesMap.get(dest).equalsIgnoreCase(origin))) {
			return true;
		}
		return false;
	}
}
