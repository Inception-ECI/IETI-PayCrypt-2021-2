package com.inception.paycrypt.model;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.utils.PaymentMethod;
import com.inception.paycrypt.utils.SourceCurrency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
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
    @Indexed(unique = true)
    private String id;

    /**
     * Target currency of order
     */
    private int targetCurrency_id;

    /**
     * Source currency of order
     */
    private SourceCurrency sourceCurrency_id;

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
    private PaymentMethod paymentMethod_id;

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
        this.id = orderDto.getId();
        this.targetCurrency_id = orderDto.getTargetCurrency_id();
        this.sourceCurrency_id = orderDto.getSourceCurrency_id();
        this.targetValue = orderDto.getTargetValue();
        this.sourceValue = orderDto.getSourceValue();
        this.paymentMethod_id = orderDto.getPaymentMethod_id();
        this.expirationDate = orderDto.getExpirationDate();
        this.creationDate = orderDto.getCreationDate();

    }

    /**
     * Update the information of the Order
     */
    public void Order(OrderDto orderDto){
        this.targetCurrency_id = orderDto.getTargetCurrency_id();
        this.sourceCurrency_id = orderDto.getSourceCurrency_id();
        this.paymentMethod_id = orderDto.getPaymentMethod_id();
    }

}
