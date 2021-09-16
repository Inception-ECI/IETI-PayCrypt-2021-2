package com.inception.paycrypt.service.impl;

import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.dto.RequestConversionMore;
import com.inception.paycrypt.dto.ResponseConversionDto;
import com.inception.paycrypt.service.ConversionService;
import com.inception.paycrypt.utils.CurrencyCode;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation class for conversionService
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("conversionServiceImpl")
public class ConversionServiceImpl implements ConversionService {

    /**
     *
     */
    @Value("${currency.api.url}")
    private String currencyUrl;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseConversionDto conversionCurrency(RequestConversionDto request) throws IOException {
        HttpResponse response = requestToApi(request.getSourceCurrency().name(), request.getTargetCurrency().name());
        ResponseConversionDto responseConversionDto = null;
        if (response != null) {
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            JSONObject json = new JSONObject(responseString);
            responseConversionDto=new ResponseConversionDto();
            responseConversionDto.setCurrency(request.getTargetCurrency());
            responseConversionDto.setDate(json.get("date").toString());
            BigDecimal value =new BigDecimal(String.valueOf(json.get(request.getTargetCurrency().name().toLowerCase())));
            value =value.multiply(BigDecimal.valueOf(request.getSourceValue()));
            responseConversionDto.setValue(value);
        }

        return responseConversionDto;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ResponseConversionDto> conversionCurrencyWithMoreCurrency(RequestConversionMore request) throws IOException {
        List<ResponseConversionDto> response = new ArrayList<>();
        for (CurrencyCode currencyCode:request.getCurrencyCodes()){
            RequestConversionDto requestConversionDto = new RequestConversionDto();
            requestConversionDto.setTargetCurrency(currencyCode);
            requestConversionDto.setSourceCurrency(request.getSourceCurrency());
            requestConversionDto.setSourceValue(request.getSourceValue());
            response.add(conversionCurrency(requestConversionDto));
        }

        return response;
    }

    /**
     * External api request
     * @param sourceCurrency sourceCurrency to conversion
     * @param targetCurrency targetCurrency to conversion
     * @return httpResponse to external api
     */
    private HttpResponse requestToApi(String sourceCurrency, String targetCurrency) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpResponse response = null;
        HttpGet request = new HttpGet(currencyUrl + sourceCurrency.toLowerCase() + "/" + targetCurrency.toLowerCase() + ".json");
        try {
            response = httpClient.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
