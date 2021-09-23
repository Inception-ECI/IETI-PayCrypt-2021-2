package com.inception.paycrypt.service.impl;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.exception.OrderServiceException;
import com.inception.paycrypt.exception.UserServiceException;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.repository.OrderRepository;
import com.inception.paycrypt.service.OrderService;
import com.inception.paycrypt.utils.CurrencyCode;
import com.inception.paycrypt.utils.OrderState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

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
    private final static int DEFAULT_ORDER_EXPIRATION_MINUTE=5;

    /**
     * The {@link OrderRepository}
     */
    private final OrderRepository orderRepository;

    /**
     * The {@link ConversionServiceImpl} to convert currencies
     */
    private final ConversionServiceImpl conversionService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Order create(OrderDto orderDto) throws IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,DEFAULT_ORDER_EXPIRATION_MINUTE);
        orderDto.setExpirationDate(calendar.getTime());
        orderDto.setOrderState(OrderState.IN_PROGRESS);
        orderDto.setSourceValue(conversionCurrency(orderDto));
        return orderRepository.save(new Order(orderDto));
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
    public Order updateOrderDate(final OrderDto orderDto, final String id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.updateExpiration(orderDto.getExpirationDate());
            orderRepository.save(order);
            return order;
        }
        throw new OrderServiceException(OrderServiceException.ORDER_NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Order updateTargetValue(String orderId, CurrencyCode targetCurrencyCode) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.updateTarget(targetCurrencyCode);
            orderRepository.save(order);
            return order;
        }
        throw new OrderServiceException(OrderServiceException.ORDER_NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Order updateSourceValue(String orderId, CurrencyCode sourceCurrencyCode) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.updateSource(sourceCurrencyCode);
            orderRepository.save(order);
            return order;
        }
        throw new OrderServiceException(OrderServiceException.ORDER_NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteOrder(String id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderServiceException(OrderServiceException.ORDER_NOT_FOUND);
        }
        orderRepository.deleteById(id);
    }

    private String conversionCurrency(OrderDto orderDto) throws IOException {
        RequestConversionDto requestConversion = new RequestConversionDto();
        requestConversion.setSourceCurrency(orderDto.getTargetCurrencyCode());
        requestConversion.setTargetCurrency(orderDto.getSourceCurrencyCode());
        requestConversion.setSourceValue(Double.parseDouble(orderDto.getTargetValue()));
        return conversionService.conversionCurrency(requestConversion).getValue().toString();
    }
}
