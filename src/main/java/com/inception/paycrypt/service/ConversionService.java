package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.RequestConversionDto;

public interface ConversionService {

     double conversionCurrency(RequestConversionDto request);
}
