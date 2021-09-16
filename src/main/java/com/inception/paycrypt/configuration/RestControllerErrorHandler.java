package com.inception.paycrypt.configuration;

import com.inception.paycrypt.error.InternalServerErrorException;
import com.inception.paycrypt.exception.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * Class to handle the exceptions present in the Rest Controllers
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@RestControllerAdvice
public class RestControllerErrorHandler {

	/**
	 * Handler of the {@link HttpMessageNotReadableException} exception
	 *
	 * @param exception The {@link HttpMessageNotReadableException}
	 * @return The response when error appears
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	private ResponseEntity<String> handleHTTPMessageNotReadable(HttpMessageNotReadableException exception) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getCause().getMessage());
	}

	/**
	 * Handler of the {@link MissingServletRequestPartException} exception
	 *
	 * @param exception The {@link MissingServletRequestPartException}
	 * @return The response when error appears
	 */
	@ExceptionHandler(MissingServletRequestPartException.class)
	private ResponseEntity<String> handleMissingServletRequestPart(MissingServletRequestPartException exception) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getCause().getMessage());
	}

	/**
	 * Handler of the {@link InternalServerErrorException} exception
	 *
	 * @param exception The {@link InternalServerErrorException}
	 * @return The response when error appears
	 */
	@ExceptionHandler(InternalServerErrorException.class)
	private ResponseEntity<ServerErrorResponseDto> handleRuntimeException(InternalServerErrorException exception) {

		return ResponseEntity.status(exception.getHttpStatus()).body(exception.getServerErrorResponseDto());
	}

}
