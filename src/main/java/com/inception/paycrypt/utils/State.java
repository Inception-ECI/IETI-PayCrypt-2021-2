package com.inception.paycrypt.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum class for users states
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum State {

	/**
	 * State when the account is active
	 */
	ACTIVE("The Account is Activated"),

	/**
	 * State when the account is disabled
	 */
	DISABLED("The Account is disabled"),

	/**
	 * State when the account is suspended
	 */
	SUSPENDED("The Account is Suspended");

	/**
	 * Description of the state
	 */
	private final String description;

}
