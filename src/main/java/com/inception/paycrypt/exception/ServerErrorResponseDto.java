package com.inception.paycrypt.exception;

import com.inception.paycrypt.error.ErrorCodeEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Server error response Dto
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
public class ServerErrorResponseDto {

	/**
	 * Error Message
	 */
	private final String message;

	/**
	 * Error code
	 */
	private final ErrorCodeEnum errorCode;

	/**
	 * Http Status code
	 */
	private final int httpStatus;

	/**
	 * Constructor
	 *
	 * @param message    The error message
	 * @param errorCode  The error code
	 * @param httpStatus The http status
	 */
	public ServerErrorResponseDto(final String message, final ErrorCodeEnum errorCode, final HttpStatus httpStatus) {

		this.message = message;
		this.errorCode = errorCode;
		this.httpStatus = httpStatus.value();
	}

}
