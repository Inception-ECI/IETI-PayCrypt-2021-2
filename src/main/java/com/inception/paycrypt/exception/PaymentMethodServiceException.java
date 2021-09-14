package com.inception.paycrypt.exception;

import com.inception.paycrypt.error.ErrorCodeEnum;
import com.inception.paycrypt.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

/**
 * The exception to be thrown when an error is present in the UserService
 *
 * @author Guillermo Castro (guillermo.castro@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public class PaymentMethodServiceException extends InternalServerErrorException {

    /**
     * Payment Method Not Found Message
     */
    public static final String PAYMENT_METHOD_NOT_FOUND = "The Payment Method is not found in the records";

    /**
     * Constructor
     *
     * @param message Message of the Exception
     */
    public PaymentMethodServiceException(String message) {

        super(new ServerErrorResponseDto(message, ErrorCodeEnum.PAYMENT_METHOD_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

}

