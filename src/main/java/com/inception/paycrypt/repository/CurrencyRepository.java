package com.inception.paycrypt.repository;

import com.inception.paycrypt.model.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository for currency
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CurrencyRepository extends MongoRepository<Currency,String> {
}
