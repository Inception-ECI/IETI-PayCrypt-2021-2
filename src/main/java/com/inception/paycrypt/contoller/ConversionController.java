package com.inception.paycrypt.contoller;

import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.dto.RequestConversionMore;
import com.inception.paycrypt.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/conversion")
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @PostMapping
    public ResponseEntity<?> conversionOperation(@RequestBody RequestConversionDto request){
        try{
            return new ResponseEntity<>(conversionService.conversionCurrency(request),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/more")
    public ResponseEntity<?> conversionCurrency(@RequestBody RequestConversionMore request){
        try {
            return new ResponseEntity<>(conversionService.conversionCurrencyWithMoreCurrency(request),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
