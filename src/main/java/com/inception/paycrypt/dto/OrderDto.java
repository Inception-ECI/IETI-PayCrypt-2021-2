package com.inception.paycrypt.dto;

import com.inception.paycrypt.model.PaymentMethod;
import com.inception.paycrypt.utils.CurrencyCode;
import com.inception.paycrypt.utils.OrderState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Mapping class for the User class
 *
 * @author Laura Bernal
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    /**
     * Target currency of order
     */
    private CurrencyCode targetCurrencyCode;

    /**
     * Source currency of order
     */
    private CurrencyCode sourceCurrencyCode;

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
    private String paymentMethodId;

    /**
     * Date expiration of order
     */
    private Date expirationDate;

    /**
     * State of the order
     */
    private OrderState orderState;

    /**
     * Payment token
     */
    private String paymentToken;
}
