package com.inception.paycrypt.dto;

import com.inception.paycrypt.utils.CurrencyCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 *  Class to mapping conversion
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
public class ResponseConversionDto {

    /**
     * Response to conversion result
     */
    private BigDecimal value;

    /**
     * date of data api update
     */
    private String date;

    /**
     *  CurrencyCode for value
     */
    private CurrencyCode currency;
}
