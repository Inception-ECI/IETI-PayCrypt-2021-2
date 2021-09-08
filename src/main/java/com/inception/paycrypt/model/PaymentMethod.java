package com.inception.paycrypt.model;

import com.inception.paycrypt.dto.PaymentMethodDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
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
public class PaymentMethod{

    /**
     * The PaymentMethod identifier
     */
    @Id
    private String id;

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

    /**
     * Constructor used to map a PaymentMethodDTO to a PaymentMethod class
     *
     * @param PaymentMethodDTO The {@link PaymentMethodDTO} to be mapped
     */
    public PaymentMethod(PaymentMethodDTO PaymentMethodDTO){
        this.sourceCurrency_id=PaymentMethodDTO.getSourceCurrency_id();
        this.targetCurrency_id=PaymentMethodDTO.getTargetCurrency_id();
        this.fee=PaymentMethodDTO.getFee();
        this.creationDate=PaymentMethodDTO.getCreationDate();
        this.modificationDate=PaymentMethodDTO.getModificationDate();

    }
}
