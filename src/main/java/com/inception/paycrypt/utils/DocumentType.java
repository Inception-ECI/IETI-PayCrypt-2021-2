package com.inception.paycrypt.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This enum contains the Available document types for the server
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum DocumentType {

	/**
	 * Cédula de ciudadanía
	 */
	CC(new Country[] {Country.CO}),

	/**
	 * Cédula de extranjería
	 */
	CE(new Country[] {Country.AR, Country.CL, Country.CO, Country.ES, Country.MX, Country.PE, Country.US});

	/**
	 * Countries that have the DocumentType
	 */
	private final Country[] countries;

}
