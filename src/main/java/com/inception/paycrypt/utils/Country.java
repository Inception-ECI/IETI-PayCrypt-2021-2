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

	/**
	 * Argentina Country.
	 */
	AR("ARGENTINA", "AR"),

	/**
	 * Brasil Country.
	 */
	BR("BRAZIL", "BR"),

	/**
	 * Canada Country.
	 */
	CA("CANADA", "CA"),

	/**
	 * Chile Country.
	 */
	CL("CHILE", "CL"),

	/**
	 * Colombia Country.
	 */
	CO("COLOMBIA", "CO"),

	/**
	 * France Country.
	 */
	FR("FRANCE", "FR"),

	/**
	 * Mexico Country.
	 */
	MX("MEXICO", "MX"),

	/**
	 * Peru Country.
	 */
	PE("PERU", "PE"),

	/**
	 * Spain Country.
	 */
	ES("SPAIN", "ES"),

	/**
	 * United States Country
	 */
	US("UNITED STATES", "US");

	/**
	 * The Country Name
	 */
	private final String description;

	/**
	 * The Country ISO Code (3166)
	 */
	private final String isoCode3166;

}
