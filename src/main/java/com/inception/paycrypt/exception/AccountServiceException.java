package com.inception.paycrypt.exception;

import com.inception.paycrypt.error.ErrorCodeEnum;
import com.inception.paycrypt.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

/**
 * The exception to be thrown when an error is present in the Account Service
 *
 * @author Paula Guevara
 * @version 1.0.0
 * @since 1.0.0
 */
public class AccountServiceException extends InternalServerErrorException {

    /**
     * Account Not Found Message
     */
    public static final String ACCOUNT_NOT_FOUND = "The Account is not found in the records";

    public AccountServiceException(String message){

        super(new ServerErrorResponseDto(message, ErrorCodeEnum.ACCOUNT_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
