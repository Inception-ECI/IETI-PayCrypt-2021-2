package com.inception.paycrypt.exception;

import com.inception.paycrypt.error.ErrorCodeEnum;
import com.inception.paycrypt.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class OrderServiceException extends InternalServerErrorException {


    public static final String ORDEN_NOT_FOUND = "Orden not found";

    public OrderServiceException(String message) {
        super(new ServerErrorResponseDto(message, ErrorCodeEnum.ORDEN_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }




}
