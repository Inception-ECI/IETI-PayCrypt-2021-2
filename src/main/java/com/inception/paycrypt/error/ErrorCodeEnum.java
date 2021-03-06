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
	 * Order not found
	 */
	ORDER_NOT_FOUND,

  	/*
	 * account not found
	 */
	ACCOUNT_SERVICE_ERROR,

  	/**
	 * Payment Method not found
	 */
	PAYMENT_METHOD_NOT_FOUND
}
