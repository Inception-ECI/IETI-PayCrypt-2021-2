package com.inception.paycrypt.model;

import java.util.Date;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.utils.CurrencyCode;
import com.inception.paycrypt.utils.OrderState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
	 * ID orden
	 */
	@Id
	private String id;

	/**
	 * Source account
	 */
	private String sourceAccount;

	/**
	 * Target account
	 */
	private String targetAccount;

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
	private String paymentMethodId;

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
	public Order(OrderDto orderDto) {

		this.sourceAccount = orderDto.getSourceAccount();
		this.targetAccount = orderDto.getTargetAccount();
		this.targetCurrencyCode = orderDto.getTargetCurrencyCode();
		this.sourceCurrencyCode = orderDto.getSourceCurrencyCode();
		this.targetValue = orderDto.getTargetValue();
		this.sourceValue = orderDto.getSourceValue();
		this.paymentMethodId = orderDto.getPaymentMethodId();
		this.expirationDate = orderDto.getExpirationDate();
		this.orderState = orderDto.getOrderState();
		this.creationDate = new Date();
		this.modificationDate = new Date();
	}

	/**
	 * Update the information of the Order
	 */
	public void update(OrderDto orderDto) {

		this.sourceAccount = orderDto.getSourceAccount();
		this.sourceCurrencyCode = orderDto.getSourceCurrencyCode();
		this.sourceValue = orderDto.getSourceValue();
		this.paymentMethodId = orderDto.getPaymentMethodId();
		this.orderState = orderDto.getOrderState();
		this.modificationDate = new Date();
	}

	/**
	 * Update the information of the Order (Target)
	 */
	public void updateTarget(final OrderDto orderDto) {

		this.targetAccount = orderDto.getTargetAccount();
		this.targetCurrencyCode = orderDto.getTargetCurrencyCode();
		this.targetValue = orderDto.getTargetValue();
	}

	/**
	 * Update the information of the Order (Source)
	 */
	public void updateSource(final OrderDto orderDto) {

		this.sourceAccount = orderDto.getSourceAccount();
		this.sourceCurrencyCode = orderDto.getSourceCurrencyCode();
		this.sourceValue = orderDto.getSourceValue();
	}

}
