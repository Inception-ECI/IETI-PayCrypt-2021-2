package com.inception.paycrypt.service.impl;

import java.io.IOException;
import java.util.Date;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.model.Transaction;
import com.inception.paycrypt.service.OrderService;
import com.inception.paycrypt.service.PaymentService;
import com.inception.paycrypt.utils.OrderState;
import com.inception.paycrypt.utils.TokenUtils;
import com.inception.paycrypt.utils.TransactionState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Payment link MongoDB service
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("paymentService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentServiceImpl implements PaymentService {

	/**
	 * The {@link OrderService}
	 */
	private final OrderService orderService;

	/**
	 * The {@link ConversionServiceImpl} to convert currencies
	 */
	private final ConversionServiceImpl conversionService;

	private final TransactionServiceMongoDB transactionService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String generateToken(OrderDto orderDto) throws IOException {

		RequestConversionDto requestConversion = new RequestConversionDto();
		requestConversion.setSourceCurrency(orderDto.getTargetCurrencyCode());
		requestConversion.setTargetCurrency(orderDto.getSourceCurrencyCode());
		requestConversion.setSourceValue(Double.parseDouble(orderDto.getTargetValue()));
		orderDto.setSourceValue(conversionService.conversionCurrency(requestConversion).getValue().toString());
		orderDto.setOrderState(OrderState.IN_PROGRESS);
		Order order = orderService.create(orderDto);

		return order.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean payLink(String paymentToken) {

		boolean canPay = false;
		Order order = orderService.findById(paymentToken);
		if (order.getOrderState().equals(OrderState.IN_PROGRESS) && order.getExpirationDate().after(new Date())) {

			order.setOrderState(OrderState.PAID);
			orderService.update(order);
			canPay = true;
		}

		return canPay;
	}

	@Override
	public boolean payOrder(final String token, final String orderId) {

		boolean canPay = false;
		Order order = orderService.findById(orderId);
		Transaction transaction = transactionService.findByOrder(orderId);
		if (order.getOrderState().equals(OrderState.IN_PROGRESS) && order.getExpirationDate().after(new Date())) {
			transaction.setSourceUserId(TokenUtils.extractUserId(token));
			transaction.setDescription("Payment Completed");
			transaction.setState(TransactionState.APPROVED);
			canPay = true;
		} else {
			transaction.setDescription("Payment Declined");
			transaction.setErrorMessage("Payment Invalid");
			transaction.setState(TransactionState.REJECTED);
		}
		transactionService.create(transaction);

		return canPay;
	}
}
