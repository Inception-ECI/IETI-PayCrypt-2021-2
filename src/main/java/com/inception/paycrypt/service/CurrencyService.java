package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.CurrencyDto;
import com.inception.paycrypt.model.Currency;
import com.inception.paycrypt.utils.CurrencyCode;
import org.springframework.stereotype.Service;

/**
 * Define the signature to implement a Currency Service
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface CurrencyService {

	/**
	 * Find a currency given his code
	 *
	 * @param currencyCode The currency code
	 * @return The currency that has been found
	 */
	Currency findByCode(final CurrencyCode currencyCode);

	/**
	 * Create a Currency
	 *
	 * @param currencyDto The {@link CurrencyDto} to be created in the records
	 * @return The user that is now in the records
	 */
	Currency create(final CurrencyDto currencyDto);

	/**
	 * Method to update a {@link Currency}
	 *
	 * @param currencyDto The {@link CurrencyDto} with the new information
	 * @param id          The {@link CurrencyDto} id to be updated in the records
	 * @return The updated {@link CurrencyDto}
	 */
	Currency update(final CurrencyDto currencyDto, final String id);

	/**
	 * Method to delete a {@link Currency}
	 *
	 * @param id The {@link Currency} id to be deleted in the records
	 */
	void deleteById(final String id);

}
