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

    /***
     * Create order
     * @param orderDto
     * @return
     */
    Order create(OrderDto orderDto);

    /**
     * Update a order
     * @param orderDto
     * @param id
     * @return
     */
    Order updateOrderDate (OrderDto orderDto, String id );

    /**
     * Delete a order
     * @param id
     */
    void deleteOrder(String id);

    /**
     * Update of target currency
     * @param orderDto
     * @param targetCurrencyCode
     * @return
     */
    Order updateTargetValue (OrderDto orderDto, CurrencyCode targetCurrencyCode);

    /**
     * Update of sources currency
     *
     * param orderDto
     * @param sourceCurrencyCode
     * @return
     */
    Order updateSourcetValue (OrderDto orderDto, CurrencyCode sourceCurrencyCode);


}
