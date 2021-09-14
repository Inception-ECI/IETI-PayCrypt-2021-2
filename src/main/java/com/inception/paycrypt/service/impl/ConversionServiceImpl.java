package com.inception.paycrypt.service.impl;

import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.service.ConversionService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Value("${currency.api.url}")
    private String currencyUrl;

    @Override
    public double conversionCurrency(RequestConversionDto request) {
       HttpResponse response = requestToApi(request.getSourceCurrency().name(),request.getTargetCurrency().name());
       if(response!=null){
        HttpEntity entity = response.getEntity();
           try {
               String responseString = EntityUtils.toString(entity, "UTF-8");
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
        return 0;
    }

    private HttpResponse requestToApi(String sourceCurrency, String targetCurrency){
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpResponse response=null;
        HttpGet request = new HttpGet(currencyUrl+sourceCurrency.toLowerCase()+"/"+targetCurrency.toLowerCase()+".json");
        try {
            response=httpClient.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
