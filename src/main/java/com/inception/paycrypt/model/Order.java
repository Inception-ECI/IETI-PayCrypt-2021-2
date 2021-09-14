package com.inception.paycrypt.model;

import com.inception.paycrypt.dto.OrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private Currency targetCurrency;

    /**
     * Source currency of order
     */
    private Currency sourceCurrency;

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
     * Date expiration of order
     */
    private Date expirationDate;

    /**
     * Date creation of order
     */
    private Date creationDate;

    /**
     * Constructor used to map a OrderDto to a Order class
     */
    public Order(OrderDto orderDto){
        this.targetCurrency = orderDto.getTargetCurrency();
        this.sourceCurrency = orderDto.getSourceCurrency();
        this.targetValue = orderDto.getTargetValue();
        this.sourceValue = orderDto.getSourceValue();
        this.paymentMethod = orderDto.getPaymentMethod();
        this.expirationDate = orderDto.getExpirationDate();
        this.creationDate = new Date();
    }

    /**
     * Update the information of the Order
     */
    public void update(OrderDto orderDto){
        this.targetCurrency = orderDto.getTargetCurrency();
        this.sourceCurrency = orderDto.getSourceCurrency();
        this.targetValue = orderDto.getTargetValue();
        this.sourceValue = orderDto.getSourceValue();
        this.paymentMethod = orderDto.getPaymentMethod();
    }

}
