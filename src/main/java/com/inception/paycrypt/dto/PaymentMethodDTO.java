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
    private String SourceCurrency_id;

    /**
     * The Target Currency identifier
     */
    private String TargetCurrency_id;

    /**
     * The amount of money of the transaction to be made
     */
    private BigInteger Fee;

    /**
     * The Payment Method creation date
     */
    private Date CreationDate;

    /**
     * The Payment Method Modification date
     */
    private Date ModificationDate;

}
