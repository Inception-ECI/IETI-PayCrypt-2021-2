package com.inception.paycrypt.repository;

import com.inception.paycrypt.model.Account;
import com.inception.paycrypt.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * MongoDB Account Repository
 *
 * @author Paula Guevara
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AccountRepository extends MongoRepository<Account,String>  {

    /**
     * Method to find a account by his id
     *
     * @param id The User email
     * @return The Optional for the User
     */
    Optional<Account> findBy(String id);
}
