package com.inception.paycrypt.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This enum contains the Available countries in the server
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum Country {

	AR("ARGENTINA", "AR"),

	BR("BRASIL", "BR"),

	CA("CANADA", "CA"),

	CL("CHILE", "CL"),

	CO("COLOMBIA", "CO"),

	FR("FRANCIA", "FR"),

	MX("MÉXICO", "MX"),

	PE("PERÚ", "PE"),

	ES("ESPAÑA", "ES"),

	US("UNITED STATES", "US");

	private final String description;

	private final String isoCode3166;

}
