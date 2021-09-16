package com.inception.paycrypt.service.impl;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.exception.OrderServiceException;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.repository.OrderRepository;
import com.inception.paycrypt.service.OrderService;
import com.inception.paycrypt.utils.CurrencyCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

import static com.inception.paycrypt.utils.UserRoles.ADMIN;

/**
 * Implementation class for conversionService
 *
 * @author Laura Bernal
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("orderServiceMongoDB")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceMongoDB implements OrderService{

    /**
     * The {@link OrderRepository}
     */
    private final OrderRepository orderRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Order create(final OrderDto orderDto) {

        return orderRepository.save(new Order(orderDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Order findById(final String id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {

            return optionalOrder.get();
        }

        throw new OrderServiceException(OrderServiceException.ORDEN_NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Order updateOrderDate(final OrderDto orderDto, final String id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.updateExpiration(orderDto.getExpirationDate());
            orderRepository.save(order);
            return order;
        }
        throw new OrderServiceException(OrderServiceException.ORDEN_NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Order updateTargetValue(final String orderId, final CurrencyCode targetCurrencyCode) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.updateTarget(targetCurrencyCode);
            orderRepository.save(order);
            return order;
        }
        throw new OrderServiceException(OrderServiceException.ORDEN_NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Order updateSourceValue(final String orderId, final CurrencyCode sourceCurrencyCode) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.updateSource(sourceCurrencyCode);
            orderRepository.save(order);
            return order;
        }
        throw new OrderServiceException(OrderServiceException.ORDEN_NOT_FOUND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteOrder(final String id) {
        if(!orderRepository.existsById(id)){
            throw  new OrderServiceException(OrderServiceException.ORDEN_NOT_FOUND);
        }
        orderRepository.deleteById(id);
    }

}
