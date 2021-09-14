package com.inception.paycrypt.exception;

import com.inception.paycrypt.error.ErrorCodeEnum;
import com.inception.paycrypt.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

/**
 * The exception to be thrown when an error is present in the UserService
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public class UserServiceException extends InternalServerErrorException {

	/**
	 * User Not Found Message
	 */
	public static final String USER_NOT_FOUND = "The User is not found in the records";

	/**
	 * Password don't match Message
	 */
	public static final String PASSWORD_DONT_MATCH = "The Password doesnt match with the current password";

	/**
	 * Constructor
	 *
	 * @param message Message of the Exception
	 */
	public UserServiceException(String message) {

		super(new ServerErrorResponseDto(message, ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}

}
