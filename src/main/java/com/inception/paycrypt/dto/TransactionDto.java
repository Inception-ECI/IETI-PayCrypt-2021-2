package com.inception.paycrypt.dto;

import com.inception.paycrypt.utils.TransactionState;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Mapping class for the Transaction class
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@NoArgsConstructor
public class TransactionDto {

    /**
     * The id of the order this transaction is related to
     */
    private String orderId;

    /**
     * The description of the transaction
     */
    private String description;

    /**
     * The id of the user who sent the payment
     */
    private String sourceUserId;

    /**
     * The id of the user who receive the payment
     */
    private String targetUserId;

    /**
     * The current state of the transaction
     */
    private TransactionState state;

    /**
     * Message in case of error on the transaction
     */
    private String errorMessage;

    /**
     * Creation date of the transaction
     */
    private Date creationDate;

}
