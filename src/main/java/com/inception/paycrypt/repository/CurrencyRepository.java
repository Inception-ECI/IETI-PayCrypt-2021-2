package com.inception.paycrypt.repository;

import java.util.Optional;

import com.inception.paycrypt.model.Currency;
import com.inception.paycrypt.utils.CurrencyCode;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository for currency
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CurrencyRepository extends MongoRepository<Currency,String> {

	/**
	 * Find a currency using his code
	 *
	 * @param currencyCode The {@link CurrencyCode}
	 * @return
	 */
	Optional<Currency> findByCurrencyCode(final CurrencyCode currencyCode);

}
