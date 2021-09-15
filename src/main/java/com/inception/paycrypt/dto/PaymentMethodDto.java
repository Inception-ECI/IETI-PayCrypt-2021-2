package com.inception.paycrypt.dto;

import com.inception.paycrypt.utils.CurrencyCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 *  Mapping class for the PaymentMethod class
 *
 * @author Guillermo castro
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@NoArgsConstructor
public class PaymentMethodDto {

    /**
     * The Source Currency identifier
     */
    private CurrencyCode sourceCurrencyCode;

    /**
     * The Target Currency identifier
     */
    private CurrencyCode targetCurrencyCode;

    /**
     * Percentage of money we are going to charge per transaction made
     */
    private int fee;

    /**
     * The Payment Method creation date
     */
    private Date creationDate;

    /**
     * The Payment Method Modification date
     */
    private Date modificationDate;

}
