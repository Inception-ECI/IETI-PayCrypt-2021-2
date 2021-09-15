package com.inception.paycrypt.service.impl;

import java.util.Optional;

import com.inception.paycrypt.dto.CurrencyDto;
import com.inception.paycrypt.exception.CurrencyServiceException;
import com.inception.paycrypt.exception.UserServiceException;
import com.inception.paycrypt.model.Currency;
import com.inception.paycrypt.model.User;
import com.inception.paycrypt.repository.CurrencyRepository;
import com.inception.paycrypt.service.CurrencyService;
import com.inception.paycrypt.utils.CurrencyCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Define the signature to implement a {@link CurrencyService} using MongoDB
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("currencyServiceMongoDB")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CurrencyServiceMongoDB implements CurrencyService {

	/**
	 * MongoDB repository where the information is going to be extracted
	 */
	private final CurrencyRepository currencyRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Currency findByCode(final CurrencyCode currencyCode) {

		Optional<Currency> optionalCurrency = currencyRepository.findByCurrencyCode(currencyCode);

		if (optionalCurrency.isPresent()) {

			return optionalCurrency.get();
		}

		throw new CurrencyServiceException(CurrencyServiceException.CURRENCY_NOT_FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Currency create(final CurrencyDto currencyDto) {

		return currencyRepository.save(new Currency(currencyDto));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Currency update(final CurrencyDto currencyDto, final String id) {

		Optional<Currency> optionalCurrency = currencyRepository.findById(id);

		if (optionalCurrency.isPresent()) {
			Currency currency = optionalCurrency.get();
			currency.updateCurrency(currencyDto);
			currencyRepository.save(currency);
			return currency;
		}

		throw new CurrencyServiceException(CurrencyServiceException.CURRENCY_NOT_FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(final String id) {

		if (!currencyRepository.existsById(id)) {

			throw new CurrencyServiceException(CurrencyServiceException.CURRENCY_NOT_FOUND);
		}
		currencyRepository.deleteById(id);

	}
}
