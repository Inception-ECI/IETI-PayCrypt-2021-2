package com.inception.paycrypt.exception;

import com.inception.paycrypt.error.ErrorCodeEnum;
import com.inception.paycrypt.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

/**
 * The exception to be thrown when an error is present in the CurrencyService
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public class CurrencyServiceException extends InternalServerErrorException {

	/**
	 * Currency Not Found Message
	 */
	public static final String CURRENCY_NOT_FOUND = "The Currency is not found in the records";

	/**
	 * Constructor
	 *
	 * @param message Message of the Exception
	 */
	public CurrencyServiceException(String message) {

		super(new ServerErrorResponseDto(message, ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}

}
