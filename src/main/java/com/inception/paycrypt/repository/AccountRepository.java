package com.inception.paycrypt.repository;

import com.inception.paycrypt.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * MongoDB Account Repository
 *
 * @author Paula Guevara
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AccountRepository extends MongoRepository<Account,String>  {

    /**
     * Method to find an account by his id
     *
     * @param id The User email
     * @return The Optional for the Account
     */
    Optional<Account> findBy(String id);

    /**
     * Method to find the accounts of a user by his id
     *
     * @param userId The User id
     * @return The optional for the List account
     */
    Optional<List<Account>> findByUserId(String userId);
  
}
