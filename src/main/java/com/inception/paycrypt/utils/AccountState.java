package com.inception.paycrypt.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum class for account states
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum AccountState {

	/**
	 * State when an account is active
	 */
	ACTIVE("The Account is Active"),

	/**
	 * State when an account is disabled
	 */
	DISABLED("The Account is disabled"),

	/**
	 * State when an account is suspended
	 */
	SUSPENDED("The Account is Suspended"),

	/**
	 * State when an account is on revision
	 */
	ON_REVISION("The Account is On Revision");

	/**
	 * Description of the state
	 */
	private final String description;

}
