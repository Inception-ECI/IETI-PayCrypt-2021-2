package com.inception.paycrypt.controller;

import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.dto.RequestConversionMore;
import com.inception.paycrypt.dto.ResponseConversionDto;
import com.inception.paycrypt.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Controller to conversion service
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/conversion")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConversionController {

    /**
     * Conversion service variable
     */
    private ConversionService conversionService;

    /**
     * Method to convert a pair of currency
     *
     * @param request variable of the data sent by the user
     * @return response with conversion data
     */
    @PostMapping
    public ResponseEntity<ResponseConversionDto> conversionOperation(@RequestBody RequestConversionDto request) {
        try {
            return new ResponseEntity<>(conversionService.conversionCurrency(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Method to convert more than two currencies
     *
     * @param request variable of the data sent by the user
     * @return response with list to conversion data
     */
    @PostMapping("/more")
    public ResponseEntity<List<ResponseConversionDto>> conversionCurrency(@RequestBody RequestConversionMore request) {
        try {
            return new ResponseEntity<>(conversionService.conversionCurrencyWithMoreCurrency(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
