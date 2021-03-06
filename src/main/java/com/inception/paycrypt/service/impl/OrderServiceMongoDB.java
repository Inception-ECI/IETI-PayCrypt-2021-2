package com.inception.paycrypt.service.impl;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.exception.OrderServiceException;
import com.inception.paycrypt.exception.UserServiceException;
import com.inception.paycrypt.model.*;
import com.inception.paycrypt.repository.AccountRepository;
import com.inception.paycrypt.repository.OrderRepository;
import com.inception.paycrypt.repository.UserRepository;
import com.inception.paycrypt.service.OrderService;
import com.inception.paycrypt.utils.CurrencyCode;
import com.inception.paycrypt.utils.OrderState;
import com.inception.paycrypt.utils.TokenUtils;
import com.inception.paycrypt.utils.TransactionState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Order Service for MongoDB
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("orderServiceMongoDB")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceMongoDB implements OrderService {

	/**
	 *
	 */
	private static final int DEFAULT_ORDER_EXPIRATION_MINUTE = 5;

	/**
	 * The {@link OrderRepository}
	 */
	private final OrderRepository orderRepository;

	/**
	 * The {@link AccountRepository}
	 */
	private final AccountRepository accountRepository;

	/**
	 * The {@link UserRepository}
	 */
	private final UserRepository userRepository;

	/**
	 * The {@link ConversionServiceImpl} to convert currencies
	 */
	private final ConversionServiceImpl conversionService;

	/**
	 * The {@link PaymentMethodServiceMongoDB}
	 */
	private final PaymentMethodServiceMongoDB paymentMethodService;

	/**
	 * The {@link TransactionServiceMongoDB}
	 */
	private final TransactionServiceMongoDB transactionService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order create(String token, OrderDto orderDto) throws IOException {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, DEFAULT_ORDER_EXPIRATION_MINUTE);
		orderDto.setExpirationDate(calendar.getTime());
		orderDto.setOrderState(OrderState.IN_PROGRESS);
		Order order = orderRepository.save(new Order(orderDto));
		transactionService.create(Transaction.builder()
						 .orderId(order.getId())
						 .creationDate(new Date())
						 .state(TransactionState.IN_PROGRESS)
						 .targetUserId(TokenUtils.extractUserId(token))
						 .build());
		return order;
	}

	@Override
	public Order create(final OrderDto orderDto) throws IOException {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, DEFAULT_ORDER_EXPIRATION_MINUTE);
		orderDto.setExpirationDate(calendar.getTime());
		orderDto.setOrderState(OrderState.IN_PROGRESS);
		Order order = orderRepository.save(new Order(orderDto));

		return order;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order update(Order order) {

		return orderRepository.save(order);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order findById(String id) {

		Optional<Order> optionalOrder = orderRepository.findById(id);

		if (optionalOrder.isPresent()) {

			return optionalOrder.get();
		}

		throw new UserServiceException(OrderServiceException.ORDER_NOT_FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order updateOrderDate(final String orderId) {

		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MINUTE, DEFAULT_ORDER_EXPIRATION_MINUTE);
			order.setExpirationDate(calendar.getTime());
			orderRepository.save(order);
			return order;
		}

		throw new OrderServiceException(OrderServiceException.ORDER_NOT_FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order updateTargetValue(String orderId, OrderDto orderDto) throws IOException {

		Optional<Order> optionalOrder = orderRepository.findById(orderId);

		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			PaymentMethod paymentMethod = paymentMethodService
					.findBySourceAndTargetCurrencyCode(order.getSourceCurrencyCode(), orderDto.getTargetCurrencyCode());
			order.updateTarget(orderDto);
			orderDto.setSourceCurrencyCode(order.getSourceCurrencyCode());
			order.setSourceValue(conversionCurrency(orderDto));
			order.setPaymentMethodId(paymentMethod.getId());
			orderRepository.save(order);

			return order;
		}

		throw new OrderServiceException(OrderServiceException.ORDER_NOT_FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order updateSourceValue(String orderId, OrderDto orderDto) throws IOException {

		Optional<Order> optionalOrder = orderRepository.findById(orderId);

		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			PaymentMethod paymentMethod = paymentMethodService
					.findBySourceAndTargetCurrencyCode(orderDto.getSourceCurrencyCode(), order.getTargetCurrencyCode());
			order.updateSource(orderDto);
			orderDto.setTargetCurrencyCode(order.getTargetCurrencyCode());
			orderDto.setTargetValue(order.getTargetValue());
			order.setSourceValue(conversionCurrency(orderDto));
			order.setPaymentMethodId(paymentMethod.getId());
			orderRepository.save(order);

			return order;
		}

		throw new OrderServiceException(OrderServiceException.ORDER_NOT_FOUND);
	}

	@Override
	public User getUserByAccountId(String accountId) throws IOException {

		Optional<Account> optionalAccount = accountRepository.findById(accountId);

		if (optionalAccount.isPresent()) {

			Optional<User> optionalUser = userRepository.findById(optionalAccount.get().getUserId());

			if (optionalUser.isPresent()) {

				User user = optionalUser.get();
				user.setPassword("");

				return user;
			}
		}

		throw new OrderServiceException(OrderServiceException.ORDER_NOT_FOUND);
	}

	/**
	 * @param orderDto The {@link OrderDto} where the conversion is made
	 * @return The Conversion value
	 * @throws IOException The {@link IOException}
	 */
	private String conversionCurrency(OrderDto orderDto) throws IOException {

		RequestConversionDto requestConversion = new RequestConversionDto();
		requestConversion.setSourceCurrency(orderDto.getTargetCurrencyCode());
		requestConversion.setTargetCurrency(CurrencyCode.USD);
		requestConversion.setSourceValue(Double.parseDouble(orderDto.getTargetValue()));

		requestConversion.setSourceValue(Double.parseDouble(conversionService.conversionCurrency(requestConversion).getValue().toString()));
		requestConversion.setSourceCurrency(CurrencyCode.USD);
		requestConversion.setTargetCurrency(orderDto.getSourceCurrencyCode());

		return conversionService.conversionCurrency(requestConversion).getValue().toString();
	}

}
