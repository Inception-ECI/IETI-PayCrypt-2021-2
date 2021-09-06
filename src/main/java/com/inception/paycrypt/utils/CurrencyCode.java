package com.inception.paycrypt.utils;

import lombok.RequiredArgsConstructor;

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
