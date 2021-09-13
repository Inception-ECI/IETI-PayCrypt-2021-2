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

    @Indexed(unique = true)
    private String id;
    private int targetCurrency_id;
    private SourceCurrency sourceCurrency_id;
    private String targetValue;
    private String sourceValue;
    private PaymentMethod paymentMethod_id;
    private Date expirationDate;
    private Date creationDate;

    /**
     * Constructor
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
     * update
     */
    public void Order(OrderDto orderDto){
        this.targetCurrency_id = orderDto.getTargetCurrency_id();
        this.sourceCurrency_id = orderDto.getSourceCurrency_id();
        this.paymentMethod_id = orderDto.getPaymentMethod_id();
    }

}
