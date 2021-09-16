package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.dto.RequestConversionMore;
import com.inception.paycrypt.dto.ResponseConversionDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Interface for the service conversion class
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface ConversionService {

    /**
     * Method for currency conversion
     *
     * @param request request value RequestConversionDto
     * @return result to conversion
     * @throws IOException The {@link IOException}
     */
    ResponseConversionDto conversionCurrency(RequestConversionDto request) throws IOException;

    /**
     * Method for currency conversion with more currencies
     *
     * @param request request value  RequestConversionDto
     * @return Result to list conversion operation
     * @throws IOException The {@link IOException}
     */
    List<ResponseConversionDto> conversionCurrencyWithMoreCurrency(RequestConversionMore request) throws IOException;
}
