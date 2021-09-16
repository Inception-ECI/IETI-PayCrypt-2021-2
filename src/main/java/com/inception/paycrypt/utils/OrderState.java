package com.inception.paycrypt.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for order states
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum OrderState {

    /**
     * State when the Order is paid
     */
    PAID("The Order has been paid"),

    /**
     * State when the Order is canceled
     */
    CANCELED("The Order has been canceled"),

    /**
     * state when the Order is in progress
     */
    IN_PROGRESS("The Order is in progress");

    /**
     * Transaction states description
     */
    private final String description;
}
