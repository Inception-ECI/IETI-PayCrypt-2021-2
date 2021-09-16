package com.inception.paycrypt.model;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.utils.CurrencyCode;
import com.inception.paycrypt.utils.OrderState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * User class - That is used as Document for MongoDB
 *
 * @author Laura Bernal
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@Document
@NoArgsConstructor
public class Order {

    /**
     *  ID orden
     */
    @Id
    private String id;

    /**
     * Target currency of order
     */
    private CurrencyCode targetCurrencyCode;

    /**
     * Source currency of order
     */
    private CurrencyCode sourceCurrencyCode;

    /**
     * Target value of order
     */
    private String targetValue;

    /**
     * Source value of order
     */
    private String sourceValue;

    /**
     * Payment method of order
     */
    private PaymentMethod paymentMethod;

    /**
     * State of the order
     */
    private OrderState orderState;

    /**
     * Date expiration of order
     */
    private Date expirationDate;

    /**
     * Date creation of order
     */
    private Date creationDate;

    /**
     * The order modification date
     */
    private Date modificationDate;

    /**
     * Constructor used to map a OrderDto to a Order class
     */
    public Order(OrderDto orderDto){
        this.targetCurrencyCode = orderDto.getTargetCurrencyCode();
        this.sourceCurrencyCode = orderDto.getSourceCurrencyCode();
        this.targetValue = orderDto.getTargetValue();
        this.sourceValue = orderDto.getSourceValue();
        this.paymentMethod = orderDto.getPaymentMethod();
        this.expirationDate = orderDto.getExpirationDate();
        this.orderState = orderDto.getOrderState();
        this.creationDate = new Date();
        this.modificationDate = new Date();
    }

    /**
     * Update the information of the Order
     */
    public void update(OrderDto orderDto){
        this.targetCurrencyCode = orderDto.getTargetCurrencyCode();
        this.sourceCurrencyCode = orderDto.getSourceCurrencyCode();
        this.targetValue = orderDto.getTargetValue();
        this.sourceValue = orderDto.getSourceValue();
        this.paymentMethod = orderDto.getPaymentMethod();
        this.orderState = orderDto.getOrderState();
        this.modificationDate = new Date();
    }

    /**
     * Update date expiration
     */
    public void updateExpiration(Date expirationDate){
        this.expirationDate = expirationDate;

    }

    /**
     * Update the information of the Order (Target)
     */
    public void updateTarget(final CurrencyCode targetCurrencyCode){
        this.targetCurrencyCode = targetCurrencyCode;

    }

    /**
     * Update the information of the Order (Source)
     */
    public void updateSource(final CurrencyCode sourceCurrencyCode){
        this.sourceCurrencyCode = sourceCurrencyCode;
    }

}
