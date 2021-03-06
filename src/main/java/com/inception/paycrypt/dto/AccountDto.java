package com.inception.paycrypt.dto;

import com.inception.paycrypt.utils.AccountState;
import com.inception.paycrypt.utils.CurrencyCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Mapping class for the Account class
 *
 * @author Paula Guevara
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
public class AccountDto {

    /**
     * The user id
     */
    private String userId;

    /**
     * The currency id
     */
    private CurrencyCode currencyCode;

    /**
     * The balance of the account
     */
    private String balance;

    /**
     * The account state
     */
    private AccountState state;

    /**
     * The account creation date
     */
    private  Date creationDate;

    /**
     * The account modification date
     */
    private Date modificationDate;

}
