package com.inception.paycrypt.service;

import java.util.List;

import com.inception.paycrypt.dto.AccountDto;
import com.inception.paycrypt.model.Account;
import com.inception.paycrypt.utils.AccountState;
import org.springframework.stereotype.Service;


/**
 * Define the signature to implement an Account Service
 *
 * @author Paula Guevara
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface AccountService {

    /**
     * Create an Account
     * @param accountDto The {@link AccountDto} to be created in the records
     * @return The account that is now in the records
     */
    Account create (final AccountDto accountDto);

    /**
     * Method to find the accounts of a user by his id
     *
     * @param userId The user ID
     * @return List of account from the user
     */
    List<Account> getAllAccountsByUserid(final String userId);

    /**
     * Find an account given his Id
     * @param id The id that is going to be used to search the Account
     * @return The account that has been found
     */
    Account findById (final String id);

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
     * @param token The token
     * @return The update {@link AccountDto}
     */
    Account updateState(final String id, final AccountState state, String token);

    /**
     * Method to delete account a {@link Account}
     * @param id The {@link Account} id to be deleted in the records
     */
    void deleteById(final String id);
}
