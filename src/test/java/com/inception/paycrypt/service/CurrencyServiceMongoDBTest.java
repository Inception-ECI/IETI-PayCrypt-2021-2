package com.inception.paycrypt.service;

import static com.inception.paycrypt.testutils.CurrencyUtils.getValidCurrency;
import static com.inception.paycrypt.testutils.CurrencyUtils.getValidCurrencyDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.inception.paycrypt.exception.CurrencyServiceException;
import com.inception.paycrypt.model.Currency;
import com.inception.paycrypt.repository.CurrencyRepository;
import com.inception.paycrypt.service.impl.CurrencyServiceMongoDB;
import com.inception.paycrypt.utils.CurrencyCode;
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

		when(currencyRepository.findByCurrencyCode(any(CurrencyCode.class))).thenReturn(Optional.of(getValidCurrency()));

		currencyServiceMongoDB.update(getValidCurrencyDto(), CurrencyCode.BTC);
		verify(currencyRepository).save(any(Currency.class));
	}

	@Test
	void whenCurrencyIdIsNotPresent_shouldThrow_CurrencyNotFoundException() {

		when(currencyRepository.findByCurrencyCode(any(CurrencyCode.class))).thenReturn(Optional.empty());

		CurrencyServiceException currencyServiceException = assertThrows(CurrencyServiceException.class, () -> {
			currencyServiceMongoDB.update(getValidCurrencyDto(), CurrencyCode.BTC);
		});

		assertEquals(CurrencyServiceException.CURRENCY_NOT_FOUND, currencyServiceException.getServerErrorResponseDto().getMessage());
	}

	@Test
	void whenValidDelete_shouldDeleteTheCurrency() {

		when(currencyRepository.existsByCurrencyCode(any(CurrencyCode.class))).thenReturn(true);

		currencyServiceMongoDB.deleteByCurrencyCode(CurrencyCode.BRL);
		verify(currencyRepository).deleteByCurrencyCode(CurrencyCode.BRL);
	}

	@Test
	void whenCurrencyIdIsNotPresent_andDeleteRequest_shouldThrow_CurrencyNotFoundException() {

		when(currencyRepository.existsByCurrencyCode(any(CurrencyCode.class))).thenReturn(false);

		CurrencyServiceException currencyServiceException = assertThrows(CurrencyServiceException.class, () -> {
			currencyServiceMongoDB.deleteByCurrencyCode(CurrencyCode.BRL);
		});

		assertEquals(CurrencyServiceException.CURRENCY_NOT_FOUND, currencyServiceException.getServerErrorResponseDto().getMessage());
	}

}
