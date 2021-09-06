package com.inception.paycrypt.model;

import com.inception.paycrypt.dto.CurrencyDto;
import com.inception.paycrypt.utils.CurrencyCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@NoArgsConstructor
public class Currency {

    @Id
    private String id;

    private String name;

    private CurrencyCode currencyCode;

    private String logo;

    private Date creationDate;

    private Date modificationDate;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public String getLogo() {
        return logo;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void UpdateCurrency(CurrencyDto currencyDto) {
        this.currencyCode = currencyDto.getCurrencyCode();
        this.name = currencyDto.getName();
        this.logo = currencyDto.getLogo();
        this.modificationDate = new Date();
    }

    public void creationCurrency(CurrencyDto currencyDto){
        this.currencyCode = currencyDto.getCurrencyCode();
        this.name = currencyDto.getName();
        this.logo = currencyDto.getLogo();
        this.creationDate = new Date();
        this.modificationDate = new Date();
    }
}
