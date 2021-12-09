package com.inception.paycrypt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Health Controller
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/health")
@CrossOrigin(origins = "*")
public class HealthController {

	/**
	 * Health Message
	 */
	private static final String HEALTH_MESSAGE = "API Working OK!";

	/**
	 * Health endpoint
	 *
	 * @return Health message
	 */
	@GetMapping
	public String all() {

		return HEALTH_MESSAGE;
	}

}
