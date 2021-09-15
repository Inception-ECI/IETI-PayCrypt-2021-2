package com.inception.paycrypt.error;

import com.inception.paycrypt.exception.ServerErrorResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Internal server error
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public class InternalServerErrorException extends RuntimeException {

	/**
	 * The server error dto
	 */
	private final ServerErrorResponseDto serverErrorResponseDto;

	/**
	 * The http status of the exception
	 */
	private final HttpStatus httpStatus;

}
