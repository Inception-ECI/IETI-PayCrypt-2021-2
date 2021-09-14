package com.inception.paycrypt.model;

import java.util.Date;

import com.inception.paycrypt.dto.AccountDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Account class- That is used as Document for MongoDB
 *
 * @author Paula Guevara
 * @version 1.0.0
 * @since 1.0.0
 */
@Document
@Getter
@NoArgsConstructor
public class Account {

    /**
     * The Account id
     */
    @Id
    private String id;

    /**
     * The user id
     */
    private String userId;

    /**
     * The currency Id
     */
    private String currencyId;

    /**
     * the balance of the account
     */
    private String balance;

    /**
     * The account state
     */
    private String state;

    /**
     * The account creation date
     */
    private Date creationDate;

    /**
     * The account modification date
     */
    private Date modificationDate;

    /**
     * Constructor used to map a AccountDto to a Account class
     * @param accountDto The {@link AccountDto} to be mapped
     */
    public void creationAccount(AccountDto accountDto){
        this.userId = accountDto.getUserId();
        this.currencyId = accountDto.getCurrencyId();
        this.balance = accountDto.getBalance();
        this.creationDate = new Date();
        this.modificationDate = new Date();

    }

    /**
     * Method used to update information of the account
     * @param accountDto The {@link AccountDto} to be mapped
     */
    public void updateAccount(AccountDto accountDto){
        this.balance = accountDto.getBalance();
        this.state = accountDto.getState();
        this.modificationDate = accountDto.getModificationDate();
    }
}
