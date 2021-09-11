package com.inception.paycrypt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Mapping class for the Account class
 *
 * @author Paula Guevara
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@NoArgsConstructor
public class AccountDto {

    /**
     * The user id
     */
    private String user_id;

    /**
     * The currency Id
     */
    private String currency_id;

    /**
     * The balance of the account
     */
    private String balance;

    /**
     * The account state
     */
    private String state;

    /**
     * The account creation date
     */
    private  Date creationDate;

    /**
     * The account modification date
     */
    private Date modificationDate;
}
