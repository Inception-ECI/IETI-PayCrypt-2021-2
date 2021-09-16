package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.AccountDto;
import com.inception.paycrypt.model.Account;
import com.inception.paycrypt.utils.AccountState;
import org.springframework.stereotype.Service;


/**
 * Define the signature to implement a Account Service
 *
 * @author Paula Guevara
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface AccountService {

    /**
     * Create a Account
     * @param accountDto The {@link AccountDto} to be created in the records
     * @return The account that is now in the records
     */
    Account create (final AccountDto accountDto);

    /**
     * Find a account given his Id
     * @param id The id that is going to be used to search the Account
     * @return The account that has been found
     */
    Account findById (final String id);

    /**
     * Method to update account a {@link Account}
     * @param accountDto The {@link AccountDto} with the new information
     * @param accountId The {@link AccountDto} id to be updated in the record
     * @return The update {@link AccountDto}
     */
    Account updateAccount(final AccountDto accountDto, final String accountId);

    /**
     * Method to update balance of the account a {@link Account}
     * @param id The {@link AccountDto} with the new information
     * @param balance The {@link AccountDto} id to be updated in the record
     * @return The update {@link AccountDto}
     */
    Account updateBalance(final String id, final String balance);

    /**
     * Method to update state of the account a {@link Account}
     * @param id The {@link AccountDto} with the new information
     * @param state The {@link AccountDto} id to be updated in the record
     * @return The update {@link AccountDto}
     */
    Account updateState(final String id, final AccountState state);

    /**
     * Method to delete account a {@link Account}
     * @param id The {@link Account} id to be deleted in the records
     */
    void deleteById(final String id);
}
