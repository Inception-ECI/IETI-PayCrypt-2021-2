package com.inception.paycrypt.model;

import com.inception.paycrypt.dto.CurrencyDto;
import com.inception.paycrypt.utils.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Currency class - used as Document for MongoDB
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    /**
     * The currency Id
     */
    @Id
    private String id;

    /**
     * The currency name
     */
    private String name;

    /**
     *  The currency code
     */
    @Indexed(unique = true)
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

    /**
     * Constructor used for mapping information
     * @param currencyDto the CurrencyDto to be mapped
     */
    public void updateCurrency(CurrencyDto currencyDto) {
        this.currencyCode = currencyDto.getCurrencyCode();
        this.name = currencyDto.getName();
        this.logo = currencyDto.getLogo();
        this.modificationDate = new Date();
    }

    /**
     * Constructor of Currency using a CurrencyDto
     * @param currencyDto class with new information
     */
    public Currency(CurrencyDto currencyDto){

        this.currencyCode = currencyDto.getCurrencyCode();
        this.name = currencyDto.getName();
        this.logo = currencyDto.getLogo();
        this.creationDate = new Date();
        this.modificationDate = new Date();
    }
}
