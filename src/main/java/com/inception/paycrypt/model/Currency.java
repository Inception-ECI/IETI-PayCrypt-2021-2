package com.inception.paycrypt.model;

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

    private String currencyCode;

    private String logo;

    private Date creationDate;

    private Date ModificationDate;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getLogo() {
        return logo;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModificationDate() {
        return ModificationDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setModificationDate(Date modificationDate) {
        ModificationDate = modificationDate;
    }
}
