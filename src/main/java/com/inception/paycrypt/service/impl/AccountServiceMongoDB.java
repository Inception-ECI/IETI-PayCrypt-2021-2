package com.inception.paycrypt.service.impl;

import com.inception.paycrypt.dto.AccountDto;
import com.inception.paycrypt.exception.AccountServiceException;
import com.inception.paycrypt.exception.UserServiceException;
import com.inception.paycrypt.model.Account;
import com.inception.paycrypt.repository.AccountRepository;
import com.inception.paycrypt.service.AccountService;
import com.inception.paycrypt.utils.AccountState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Define the signature to implement a {@link AccountService} using MongoDB
 *
 * @author Paula Guevara
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("accountServiceMongoDB")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountServiceMongoDB implements AccountService {

    /**
     * MongoDB repository where the information is going to be extracted
     */
    private final AccountRepository accountRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Account create(final AccountDto accountDto) {
        return accountRepository.save(new Account(accountDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account findById(final String id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);

        if (optionalAccount.isPresent()) {

            return optionalAccount.get();
        }

        throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Account updateAccount(final AccountDto accountDto, final String accountId) {

        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.updateAccount(accountDto);
            accountRepository.save(account);
            return account;
        }

        throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account updateBalance(final  String id, final String balance) {

        Optional<Account> optionalBalance = accountRepository.findById(id);

        if (optionalBalance.isPresent()) {
            Account account = optionalBalance.get();
            account.updateBalance(balance);
            accountRepository.save(account);
            return account;
        }

        throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account updateState(final String id, final AccountState state) {

        Optional<Account> optionalState = accountRepository.findById(id);

        if (optionalState.isPresent()) {
            Account account = optionalState.get();
            account.updateState(state);
            accountRepository.save(account);
            return account;
        }

        throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     * @param id
     */
    @Override
    public void deleteById(final String id) {
        if(!accountRepository.existsById(id)){
            throw  new AccountServiceException(AccountServiceException.ACCOUNT_NOT_FOUND);
        }
        accountRepository.deleteById(id);
    }
}
