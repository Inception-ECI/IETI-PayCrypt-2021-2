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
    private String Id;

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

    /**
     * Constructor used to map a PaymentMethodDTO to a PaymentMethod class
     *
     * @param PaymentMethodDTO The {@link PaymentMethodDTO} to be mapped
     */
    public PaymentMethod(PaymentMethodDTO PaymentMethodDTO){
        this.SourceCurrency_id=PaymentMethodDTO.getSourceCurrency_id();
        this.TargetCurrency_id=PaymentMethodDTO.getTargetCurrency_id();
        this.Fee=PaymentMethodDTO.getFee();
        this.CreationDate=PaymentMethodDTO.getCreationDate();
        this.ModificationDate=PaymentMethodDTO.getModificationDate();

    }
}
