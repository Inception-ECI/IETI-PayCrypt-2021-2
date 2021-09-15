package com.inception.paycrypt.dto;


import com.inception.paycrypt.utils.CurrencyCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 *  Mapping class for the Conversion multiples currencys
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
public class RequestConversionMore {

    /**
     * List to CurrencyCode
     */
    private List<CurrencyCode> currencyCodes;

    /**
     * source currencyCode for service
     */
    private CurrencyCode sourceCurrency;

    /**
     * sourceValue for service
     */
    private double sourceValue;
}
