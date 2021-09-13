package com.inception.paycrypt.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentMethod {

    /**
     * Credit card
     */
    TC("CREDIT CARD", "TC"),

    /**
     * Debit card
     */
    TD("DEBIT CARD", "TD"),

    /**
     * PSE
     */
    PSE("TRANSFERENCIA BANCARIA", "PSE");

    /**
     * The payment method
     */
    private final String description;

    /**
     * acronym
     */
    private final String isoCode3166;


}
