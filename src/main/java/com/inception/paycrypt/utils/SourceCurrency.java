package com.inception.paycrypt.utils;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This enum contains the Available document types for the server
 *
 * @author laura Bernal
 * @version 1.0.0
 * @since 1.0.0
 */

@Getter
@RequiredArgsConstructor
public enum SourceCurrency {

    /**
     * Bitcoin.
     */
    BTC("BITCOIN", "BTC"),

    /**
     * Ether.
     */
    ETH("ETHER", "ETH"),

    /**
     * Rippler.
     */
    XRP("RIPPLER", "XRP"),

    /**
     * Litecoin
     */
    LTC("LITECOIN", "LTC"),

    /**
     * DEEPONION.
     */
    ONION("DEEPONION", "ONION"),

    /**
     * American dollar
     */
    USD("DOLAR", "USD"),

    /**
     * Euro
     */
    EUR("EURO", "EUR"),

    /**
     * Yen Japanese
     */
    JPY("YEN", "JPY"),

    /**
     * Colombian pesos
     */
    COP("COLOMBIAN PESOS", "COP");

    /**
     * The Currency Name
     */
    private final String currency;

    /**
     * The Currency acronym
     */
    private final String acronym;

}
