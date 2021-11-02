package com.inception.paycrypt.exception;

import com.inception.paycrypt.error.ErrorCodeEnum;
import com.inception.paycrypt.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

/**
 * The exception to be thrown when an error is present in the Account Service
 *
 * @author Paula Guevara
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public class AccountServiceException extends InternalServerErrorException {

    /**
     * Account Not Found Message
     */
    public static final String ACCOUNT_NOT_FOUND = "The Account is not found in the records";

    /**
     * Accounts Not Found Message
     */
    public static final String ACCOUNTS_NOT_FOUND = "There are not accounts for the user";

    /**
     * User not authorized
     */
    public static final String AUTHORIZATION_ERROR = "The account does not belong to user";

    /**
     * Constructor
     *
     * @param message Message
     * @param errorCode The {@link ErrorCodeEnum}
     * @param httpStatus The {@link HttpStatus}
     */
    public AccountServiceException(String message, ErrorCodeEnum errorCode, HttpStatus httpStatus){

        super(new ServerErrorResponseDto(message, errorCode, httpStatus), httpStatus);
    }
}
