package com.inception.paycrypt.service.impl;

import java.io.IOException;
import java.util.Date;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.model.Account;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.model.Transaction;
import com.inception.paycrypt.service.AccountService;
import com.inception.paycrypt.service.OrderService;
import com.inception.paycrypt.service.PaymentService;
import com.inception.paycrypt.utils.CurrencyCode;
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

	/**
	 * The {@link TransactionServiceMongoDB}
	 */
	private final TransactionServiceMongoDB transactionService;

	/**
	 * The {@link AccountService}
	 */
	private final AccountServiceMongoDB accountService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String generateToken(String authorization, OrderDto orderDto) throws IOException {

		Account account = accountService.findById(orderDto.getTargetAccount());
		orderDto.setOrderState(OrderState.IN_PROGRESS);
		orderDto.setTargetCurrencyCode(account.getCurrencyCode());
		Order order = orderService.create(authorization, orderDto);

		return order.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateStatuses(Order order) {

		Account account = accountService.findById(order.getTargetAccount());
		double newBalance = Double.parseDouble(account.getBalance()) + Double.parseDouble(order.getTargetValue());
		accountService.updateBalance(account.getId(), Double.toString(newBalance));
		order.setOrderState(OrderState.PAID);
		orderService.update(order);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean payOrder(final String orderId) {

		boolean canPay = false;
		Order order = orderService.findById(orderId);
		Transaction transaction = transactionService.findByOrder(orderId);
		if (order.getOrderState().equals(OrderState.IN_PROGRESS) && order.getExpirationDate().after(new Date())) {
			updateStatuses(order);
			transaction.setDescription("Payment Completed");
			transaction.setState(TransactionState.APPROVED);
			canPay = true;
		} else {
			order.setOrderState(OrderState.CANCELED);
			transaction.setDescription("Payment Declined");
			transaction.setErrorMessage("Payment Invalid");
			transaction.setState(TransactionState.REJECTED);
		}
		transactionService.create(transaction);

		return canPay;
	}

	@Override
	public String updateSourceCurrency(String orderId, CurrencyCode currencyCode) throws IOException {
		Order order = orderService.findById(orderId);
		RequestConversionDto requestConversion = new RequestConversionDto();
		requestConversion.setSourceCurrency(order.getTargetCurrencyCode());
		requestConversion.setTargetCurrency(currencyCode);
		requestConversion.setSourceValue(Double.parseDouble(order.getTargetValue()));
		order.setSourceValue(conversionService.conversionCurrency(requestConversion).getValue().toString());
		order.setSourceCurrencyCode(currencyCode);
		orderService.update(order);

		return order.getId();
	}
}
