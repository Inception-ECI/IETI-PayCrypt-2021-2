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
    private String name;

    private CurrencyCode currencyCode;

    private String logo;

    private Date creationDate;

    private Date modificationDate;
    
}
