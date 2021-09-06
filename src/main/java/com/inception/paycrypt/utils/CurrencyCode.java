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

    COP("Colombian peso"),
    USD("American dollar"),
    BTC("Bitcoin"),
    ETH("Ethereum"),
    ADA("Cardano"),
    EUR("Euro"),
    ARS("Argentine peso"),
    BRL("Brazilian real");

    private final String value;

    public String getValue() {
        return value;
    }
}
