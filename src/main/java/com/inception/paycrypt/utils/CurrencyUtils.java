package com.inception.paycrypt.utils;

import java.util.ArrayList;
import java.util.List;

public class CurrencyUtils {
    public static List<CurrencyCode> getNonCryptoCurrencies() {
        return new ArrayList<CurrencyCode>(){
            {
                add(CurrencyCode.COP);
                add(CurrencyCode.USD);
                add(CurrencyCode.EUR);
                add(CurrencyCode.ARS);
                add(CurrencyCode.BRL);
            }
        };
    }
}
