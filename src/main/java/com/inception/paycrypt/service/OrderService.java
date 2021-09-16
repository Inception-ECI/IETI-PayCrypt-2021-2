package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.model.Currency;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.utils.CurrencyCode;

/**
 * Define the signature to implement a Order Service
 *
 * @author Laura Bernal
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrderService {

    Order create(OrderDto orderDto);

    Order updateOrderDate (OrderDto orderDto, String id );

    void deleteOrder(String id);

    Order updateTargetValue (OrderDto orderDto, CurrencyCode targetCurrencyCode);

    Order updateSourcetValue (OrderDto orderDto, CurrencyCode sourceCurrencyCode);


}
