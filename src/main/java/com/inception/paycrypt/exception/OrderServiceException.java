package com.inception.paycrypt.exception;

import com.inception.paycrypt.error.ErrorCodeEnum;
import com.inception.paycrypt.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class OrderServiceException extends InternalServerErrorException {

    public static final String ORDER_NOT_FOUND = "The Order was not found in the records";

    public OrderServiceException(String message) {
        super(new ServerErrorResponseDto(message, ErrorCodeEnum.ORDER_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
