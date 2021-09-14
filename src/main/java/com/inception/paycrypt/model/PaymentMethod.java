package com.inception.paycrypt.model;

import com.inception.paycrypt.dto.PaymentMethodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Payment Method class - used as Document for MongoDB
 *
 * @author Guillermo Alfonso Castro
 * @version 1.0.0
 * @since 1.0.0
 */
@Document
@Getter
@NoArgsConstructor
public class PaymentMethod {

    /**
     * The PaymentMethod identifier
     */
    @Id
    private String id;

    /**
     * The Source Currency identifier
     */
    private Currency sourceCurrencyId;

    /**
     * The Target Currency identifier
     */
    private Currency targetCurrencyId;

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

    /**
     * Constructor used to map a PaymentMethodDTO to a PaymentMethod class
     *
     * @param paymentMethodDto The {@link PaymentMethodDto} to be mapped
     */
    public PaymentMethod(PaymentMethodDto paymentMethodDto) {
        this.sourceCurrencyId = paymentMethodDto.getSourceCurrencyId();
        this.targetCurrencyId = paymentMethodDto.getTargetCurrencyId();
        this.fee = paymentMethodDto.getFee();
        this.creationDate = new Date();
        this.modificationDate = new Date();
    }

    /**
     * Update the information of the Payment Method
     *
     * @param paymentMethodDto The {@link PaymentMethodDto} that contains the new information
     */
    public void update(PaymentMethodDto paymentMethodDto) {
        this.sourceCurrencyId = paymentMethodDto.getSourceCurrencyId();
        this.targetCurrencyId = paymentMethodDto.getTargetCurrencyId();
        this.fee = paymentMethodDto.getFee();
        this.modificationDate = new Date();
    }
}
