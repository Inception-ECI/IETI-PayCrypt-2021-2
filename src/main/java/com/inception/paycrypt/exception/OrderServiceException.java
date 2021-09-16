package com.inception.paycrypt.exception;

import com.inception.paycrypt.error.ErrorCodeEnum;
import com.inception.paycrypt.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class OrderServiceException extends InternalServerErrorException {

    /**
     *
     * Order not found
     */
    public static final String ORDEN_NOT_FOUND = "Order not found";

    /**
     * Constructor
     *
     * @param message
     */
    public OrderServiceException(String message) {
        super(new ServerErrorResponseDto(message, ErrorCodeEnum.ORDEN_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }


}
