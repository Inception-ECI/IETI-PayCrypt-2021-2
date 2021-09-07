package com.inception.paycrypt.dto;

import com.inception.paycrypt.utils.CurrencyCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *  Mapping class for the Currency class
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@NoArgsConstructor
public class CurrencyDto {

    /**
     * The currency name
     */
    private String name;

    /**
     * The currency code
     */
    private CurrencyCode currencyCode;

    /**
     * The currency logo
     */
    private String logo;

    /**
     * The currency creation date
     */
    private Date creationDate;

    /**
     * The currency modification date
     */
    private Date modificationDate;

}
