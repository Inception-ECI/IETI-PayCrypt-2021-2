package com.inception.paycrypt.testutils;

import java.util.Date;

import com.inception.paycrypt.dto.CurrencyDto;
import com.inception.paycrypt.model.Currency;
import com.inception.paycrypt.utils.CurrencyCode;

/**
 * Util Class used for test
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public class CurrencyUtils {

	/**
	 * Method to get a valid {@link Currency}
	 *
	 * @return A new {@link Currency}
	 */
	public static Currency getValidCurrency() {

		return Currency.builder()
					   .id("123456789")
					   .name("BitCoin")
					   .currencyCode(CurrencyCode.BTC)
					   .logo("TheLogo")
					   .creationDate(new Date())
					   .modificationDate(new Date())
					   .build();

	}

	/**
	 * Method to get a valid {@link CurrencyDto}
	 *
	 * @return A new {@link CurrencyDto}
	 */
	public static CurrencyDto getValidCurrencyDto() {

		return CurrencyDto.builder()
						  .name("BitCoin")
						  .currencyCode(CurrencyCode.BTC)
						  .logo("TheLogo")
						  .creationDate(new Date())
						  .modificationDate(new Date())
						  .build();

	}

}
