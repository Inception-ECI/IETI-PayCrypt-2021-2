package com.inception.paycrypt.dto;

import com.inception.paycrypt.utils.CurrencyCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 *  Class to mapping conversion
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@NoArgsConstructor
public class RequestConversionDto {
    private CurrencyCode sourceCurrency;

    private CurrencyCode targetCurrency;

    private double sourceValue;

}
