package com.inception.paycrypt.exception;

import com.inception.paycrypt.error.ErrorCodeEnum;
import com.inception.paycrypt.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

/**
 * Exception for the order services
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public class OrderServiceException extends InternalServerErrorException {

    /**
     * Message when the order was not found on the database
     */
    public static final String ORDER_NOT_FOUND = "The Order was not found in the records";

    /**
     * Message when the order was not found on the database
     */
    public static final String ORDER_TRANSACTION_NOT_FOUND = "The transaction with the given order was not found in the records";

    /**
     * Constructor
     *
     * @param message Message of the Exception
     */
    public OrderServiceException(String message) {
        super(new ServerErrorResponseDto(message, ErrorCodeEnum.ORDER_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
