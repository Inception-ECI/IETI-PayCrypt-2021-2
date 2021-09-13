package com.inception.paycrypt.dto;

import com.inception.paycrypt.utils.PaymentMethod;
import com.inception.paycrypt.utils.SourceCurrency;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Mapping class for the User class
 *
 * @author Laura Bernal
 * @version 1.0.0
 * @since 1.0.0
 */

@Getter
@NoArgsConstructor
public class OrderDto {

    /**
     *  ID orden
     */
    private String id;

    /**
     * Target currency of order
     */
    private int targetCurrency_id;

    /**
     * Source currency of order
     */
    private SourceCurrency sourceCurrency_id;

    /**
     * Target value of order
     */
    private String targetValue;

    /**
     * Source value of order
     */
    private String sourceValue;

    /**
     * Payment method of order
     */
    private PaymentMethod paymentMethod_id;

    /**
     * Date expiration of order
     */
    private Date expirationDate;

    /**
     * Date creation of order
     */
    private Date creationDate;

}
