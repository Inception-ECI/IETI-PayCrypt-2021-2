package com.inception.paycrypt.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum class for transaction states
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum TransactionState {

    /**
     * State when the transaction is approved
     */
    APPROVED("The transaction has been approved"),

    /**
     * State when the transaction is rejected
     */
    REJECTED("The transaction has been rejected"),

    /**
     * state when the transaction is in progress
     */
    IN_PROGRESS("The transaction is in progress");

    /**
     * Transaction states description
     */
    private final String description;

}
