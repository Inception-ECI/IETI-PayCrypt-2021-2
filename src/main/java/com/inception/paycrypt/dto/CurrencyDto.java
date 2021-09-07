package com.inception.paycrypt.dto;

import com.inception.paycrypt.utils.CurrencyCode;

import java.util.Date;

/**
 *  Mapping class for the Currency class
 *
 * @author Juan Ramos
 * @version 1.0.0
 * @since 1.0.0
 */
public class CurrencyDto {
    private String name;

    private CurrencyCode currencyCode;

    private String logo;

    private Date creationDate;

    private Date modificationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
