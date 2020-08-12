package com.coding.mastercard.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author sri anusha As per my understanding from the requirements "Any
 *         unexpected input should result in a ’no’ response." Handling the
 *         error scenerio and returning a 'no' response.
 */
@RestController
public class HandleErrorController implements ErrorController {

	@Override
	@RequestMapping("/error")
	public String getErrorPath() {
		return "no";
	}
}
