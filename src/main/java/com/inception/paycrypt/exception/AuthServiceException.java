package com.inception.paycrypt.exception;

import com.inception.paycrypt.error.ErrorCodeEnum;
import com.inception.paycrypt.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

/**
 * The exception to be thrown when an error is present in the AuthenticationService
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public class AuthServiceException extends InternalServerErrorException {

    /**
     * Invalid credential message
     */
    public static final String INVALID_CREDENTIALS = "The provided credentials are invalid";

    /**
     * Constructor
     *
     * @param message Message of the Exception
     */
    public AuthServiceException(String message) {
        super(new ServerErrorResponseDto(message, ErrorCodeEnum.INVALID_USER_CREDENTIALS, HttpStatus.UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
    }
}
