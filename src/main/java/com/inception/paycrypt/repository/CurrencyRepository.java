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
	 * @return the optional currency of the found currency
	 */
	Optional<Currency> findByCurrencyCode(final CurrencyCode currencyCode);

	/**
	 * Check if a currency exists by its currency code
	 *
	 * @param currencyCode The {@link CurrencyCode}
	 * @return if the currency exists
	 */
	boolean existsByCurrencyCode(final CurrencyCode currencyCode);

	/**
	 * Deletes a currency by its currency code
	 *
	 * @param currencyCode The {@link CurrencyCode}
	 */
	void deleteByCurrencyCode(final CurrencyCode currencyCode);

}
