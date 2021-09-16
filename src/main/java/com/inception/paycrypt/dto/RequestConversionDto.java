package com.inception.paycrypt.dto;

import com.inception.paycrypt.utils.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *  Class to mapping conversion
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestConversionDto {

    /**
     *  sourceCurrency for conversion service
     */
    private CurrencyCode sourceCurrency;

    /**
     *  targetCurrency for conversion service
     */
    private CurrencyCode targetCurrency;

    /**
     *  sourceValue for conversion service
     */
    private double sourceValue;


}
