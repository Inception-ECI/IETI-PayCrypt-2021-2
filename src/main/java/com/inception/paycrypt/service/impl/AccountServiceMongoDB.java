package com.inception.paycrypt.service.impl;

import com.inception.paycrypt.dto.AccountDto;
import com.inception.paycrypt.error.ErrorCodeEnum;
import com.inception.paycrypt.exception.AccountServiceException;
import com.inception.paycrypt.model.Account;
import com.inception.paycrypt.repository.AccountRepository;
import com.inception.paycrypt.service.AccountService;
import com.inception.paycrypt.utils.AccountState;
import com.inception.paycrypt.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Define the signature to implement a {@link AccountService} using MongoDB
 *
 * @author Paula Guevara
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
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
    public List<Account> getAllAccountsByUserid(final String userId) {

        Optional<List<Account>> optionalAccounts = accountRepository.findByUserId(userId);

        if (optionalAccounts.isPresent()) {
            return optionalAccounts.get();
        }

        throw new AccountServiceException(AccountServiceException.ACCOUNT_NOT_FOUND, ErrorCodeEnum.ACCOUNT_SERVICE_ERROR, HttpStatus.NOT_FOUND);
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

        throw new AccountServiceException(AccountServiceException.ACCOUNT_NOT_FOUND, ErrorCodeEnum.ACCOUNT_SERVICE_ERROR, HttpStatus.NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account updateBalance(final String id, final String balance) {

        Optional<Account> optionalBalance = accountRepository.findById(id);

        if (optionalBalance.isPresent()) {
            Account account = optionalBalance.get();
            account.updateBalance(balance);
            accountRepository.save(account);
            return account;
        }

        throw new AccountServiceException(AccountServiceException.ACCOUNT_NOT_FOUND, ErrorCodeEnum.ACCOUNT_SERVICE_ERROR, HttpStatus.NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account updateState(final String id, final AccountState state, final String token) {

        Optional<Account> optionalAccount = accountRepository.findById(id);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            validateAccountOwner(account.getUserId(), TokenUtils.extractUserId(token));
            account.updateState(state);
            accountRepository.save(account);
            return account;
        }

        throw new AccountServiceException(AccountServiceException.ACCOUNT_NOT_FOUND, ErrorCodeEnum.ACCOUNT_SERVICE_ERROR, HttpStatus.NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(final String id) {
        if (!accountRepository.existsById(id)) {
            throw new AccountServiceException(AccountServiceException.ACCOUNT_NOT_FOUND, ErrorCodeEnum.ACCOUNT_SERVICE_ERROR, HttpStatus.NOT_FOUND);
        }
        accountRepository.deleteById(id);
    }

    /**
     * Validate if account belongs to owner
     *
     * @param accountUserId The account user id
     * @param tokenUserId The token account
     */
    private void validateAccountOwner(String accountUserId, String tokenUserId) {
        if (!accountUserId.equals(tokenUserId)) {
            throw new AccountServiceException(AccountServiceException.AUTHORIZATION_ERROR, ErrorCodeEnum.ACCOUNT_SERVICE_ERROR, HttpStatus.FORBIDDEN);
        }
    }
}
