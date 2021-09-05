package com.inception.paycrypt.repository;

import com.inception.paycrypt.model.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurrencyRepository extends MongoRepository<Currency,String> {
}
