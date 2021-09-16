package com.inception.paycrypt.repository;

import com.inception.paycrypt.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoDB Account Repository
 *
 * @author Paula Guevara
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AccountRepository extends MongoRepository<Account,String>  {

}
