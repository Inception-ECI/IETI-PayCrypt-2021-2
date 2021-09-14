package com.inception.paycrypt.service.impl;

import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.service.ConversionService;
import org.springframework.beans.factory.annotation.Value;

public class ConversionServiceImpl implements ConversionService {

    @Value("${currency.api.url}")
    private String currencyUrl;

    @Override
    public double conversionCurrency(RequestConversionDto request) {

        return 0;
    }
}
