package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.dto.ResponseConversionDto;

import java.io.IOException;

public interface ConversionService {

     ResponseConversionDto conversionCurrency(RequestConversionDto request) throws IOException;
}
