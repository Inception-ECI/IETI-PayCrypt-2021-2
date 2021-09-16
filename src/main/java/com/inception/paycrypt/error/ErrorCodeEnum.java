package com.inception.paycrypt.error;

/**
 * Error code Enum
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ErrorCodeEnum {

	/**
	 * User not found
	 */
	USER_NOT_FOUND,

	/**
	 * Currency not found
	 */
	CURRENCY_NOT_FOUND,

	/**
	 * User with email already exists
	 */
	USER_WITH_EMAIL_ALREADY_EXISTS,

	/**
	 * Expired token
	 */
	EXPIRED_TOKEN,

	/**
	 * Invalid user credentials
	 */
	INVALID_USER_CREDENTIALS,

	/**
	 * User not found
	 */
	ACCOUNT_NOT_FOUND

}
