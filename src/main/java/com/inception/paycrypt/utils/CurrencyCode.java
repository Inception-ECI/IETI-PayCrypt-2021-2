package com.inception.paycrypt.utils;

import lombok.RequiredArgsConstructor;

/**
 * Enum class for Currency Code
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
@RequiredArgsConstructor
public enum CurrencyCode {

    /**
     *  The currency code Colombian peso
     */
    COP("Colombian peso"),

    /**
     *  The currency code American dollar
     */
    USD("American dollar"),

    /**
     *  The currency code Bitcoin
     */
    BTC("Bitcoin"),

    /**
     *  The currency code Ethereum
     */
    ETH("Ethereum"),

    /**
     *  The currency code Cardano
     */
    ADA("Cardano"),

    /**
     *  The currency code Euro
     */
    EUR("Euro"),

    /**
     *  The currency code Argentine peso
     */
    ARS("Argentine peso"),

    /**
     *  The currency code Brazilian real
     */
    BRL("Brazilian real");

    private final String value;

    public String getValue() {
        return value;
    }
}
