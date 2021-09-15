package com.inception.paycrypt.dto;


import com.inception.paycrypt.utils.CurrencyCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RequestConversionMore {
    private List<CurrencyCode> currencyCodes;
    private CurrencyCode sourceCurrency;
    private double sourceValue;
}
