package com.inception.paycrypt.service;

import static com.inception.paycrypt.testutils.CurrencyUtils.getValidCurrency;
import static com.inception.paycrypt.testutils.CurrencyUtils.getValidCurrencyDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.inception.paycrypt.exception.CurrencyServiceException;
import com.inception.paycrypt.model.Currency;
import com.inception.paycrypt.repository.CurrencyRepository;
import com.inception.paycrypt.service.impl.CurrencyServiceMongoDB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Test class for the {@link CurrencyServiceMongoDB} class
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class CurrencyServiceMongoDBTest {

	/**
	 * Class to be tested
	 */
	private CurrencyServiceMongoDB currencyServiceMongoDB;

	/**
	 * MongoDB Repository mock
	 */
	@Mock
	private CurrencyRepository currencyRepository;

	@BeforeEach()
	void setUp() {

		currencyServiceMongoDB = new CurrencyServiceMongoDB(currencyRepository);
	}

	@Test
	void shouldCreate_aNewCurrencyInTheDatabase() {

		currencyServiceMongoDB.create(getValidCurrencyDto());
		verify(currencyRepository).save(any(Currency.class));
	}

	@Test
	void whenValidUpdate_shouldUpdateCurrencyInformation() {

		when(currencyRepository.findById(anyString())).thenReturn(Optional.of(getValidCurrency()));

		currencyServiceMongoDB.update(getValidCurrencyDto(), "983d5e23808r0s058d57de91");
		verify(currencyRepository).save(any(Currency.class));
	}

	@Test
	void whenCurrencyIdIsNotPresent_shouldThrow_CurrencyNotFoundException() {

		when(currencyRepository.findById(anyString())).thenReturn(Optional.empty());

		CurrencyServiceException currencyServiceException = assertThrows(CurrencyServiceException.class, () -> {
			currencyServiceMongoDB.update(getValidCurrencyDto(), "123456789");
		});

		assertEquals(CurrencyServiceException.CURRENCY_NOT_FOUND, currencyServiceException.getServerErrorResponseDto().getMessage());
	}

	@Test
	void whenValidDelete_shouldDeleteTheCurrency() {

		when(currencyRepository.existsById(anyString())).thenReturn(true);

		currencyServiceMongoDB.deleteById("983d5e23808r0s058d57de91");
		verify(currencyRepository).deleteById("983d5e23808r0s058d57de91");
	}

	@Test
	void whenCurrencyIdIsNotPresent_andDeleteRequest_shouldThrow_CurrencyNotFoundException() {

		when(currencyRepository.existsById(anyString())).thenReturn(false);

		CurrencyServiceException currencyServiceException = assertThrows(CurrencyServiceException.class, () -> {
			currencyServiceMongoDB.deleteById("123456789");
		});

		assertEquals(CurrencyServiceException.CURRENCY_NOT_FOUND, currencyServiceException.getServerErrorResponseDto().getMessage());
	}

}
