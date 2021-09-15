package com.inception.paycrypt.exception;

import com.inception.paycrypt.error.ErrorCodeEnum;
import com.inception.paycrypt.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class AuthServiceException extends InternalServerErrorException {

    public static final String INVALID_CREDENTIALS = "The provided credentials are invalid";


    public AuthServiceException(String message) {
        super(new ServerErrorResponseDto(message, ErrorCodeEnum.INVALID_USER_CREDENTIALS, HttpStatus.UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
    }
}
