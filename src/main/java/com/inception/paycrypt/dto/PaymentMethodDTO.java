package com.inception.paycrypt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigInteger;
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
public class PaymentMethodDTO {

    /**
     * The Source Currency identifier
     */
    private String sourceCurrency_id;

    /**
     * The Target Currency identifier
     */
    private String targetCurrency_id;

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
