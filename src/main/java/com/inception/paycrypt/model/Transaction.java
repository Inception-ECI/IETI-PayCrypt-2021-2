package com.inception.paycrypt.model;

import com.inception.paycrypt.dto.TransactionDto;
import com.inception.paycrypt.utils.TransactionState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Transaction class - That is used as Document for MongoDB
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    /**
     * The transaction identifier
     */
    @Id
    private String id;

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

    /**
     * Constructor used to map a TransactionDto to a Transaction class
     *
     * @param transactionDto The {@link TransactionDto} object that contains the data
     */
    public Transaction(TransactionDto transactionDto) {

        this.orderId = transactionDto.getOrderId();
        this.description = transactionDto.getDescription();
        this.sourceUserId = transactionDto.getSourceUserId();
        this.targetUserId = transactionDto.getTargetUserId();
        this.state = transactionDto.getState();
        this.errorMessage = transactionDto.getErrorMessage();
        this.creationDate = transactionDto.getCreationDate();
    }

}
