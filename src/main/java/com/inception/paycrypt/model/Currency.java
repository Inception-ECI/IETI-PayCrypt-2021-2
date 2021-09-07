package com.inception.paycrypt.model;

import com.inception.paycrypt.dto.CurrencyDto;
import com.inception.paycrypt.utils.CurrencyCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Currency class - used as Document for MongoDB
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
@Document
@Getter
@NoArgsConstructor
public class Currency {

    @Id
    private String id;

    private String name;

    private CurrencyCode currencyCode;

    private String logo;

    private Date creationDate;

    private Date modificationDate;

    /**
     * Constructor used for mapping information
     * @param currencyDto the CurrencyDto to be mapped
     */
    public void UpdateCurrency(CurrencyDto currencyDto) {
        this.currencyCode = currencyDto.getCurrencyCode();
        this.name = currencyDto.getName();
        this.logo = currencyDto.getLogo();
        this.modificationDate = new Date();
    }

    /**
     * Method to update information
     * @param currencyDto class with new information
     */
    public void creationCurrency(CurrencyDto currencyDto){
        this.currencyCode = currencyDto.getCurrencyCode();
        this.name = currencyDto.getName();
        this.logo = currencyDto.getLogo();
        this.creationDate = new Date();
        this.modificationDate = new Date();
    }
}
