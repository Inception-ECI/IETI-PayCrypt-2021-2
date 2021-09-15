package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.dto.RequestConversionMore;
import com.inception.paycrypt.dto.ResponseConversionDto;

import java.io.IOException;
import java.util.List;

public interface ConversionService {

     ResponseConversionDto conversionCurrency(RequestConversionDto request) throws IOException;

     List<ResponseConversionDto> conversionCurrencyWithMoreCurrency(RequestConversionMore request) throws IOException;
}
