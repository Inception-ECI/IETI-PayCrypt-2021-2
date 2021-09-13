package com.inception.paycrypt.dto;

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

    private String id;
    private int targetCurrency_id;
    private SourceCurrency sourceCurrency_id;
    private String targetValue;
    private String sourceValue;
    private PaymentMethod paymentMethod_id;
    private Date expirationDate;
    private Date creationDate;

}
