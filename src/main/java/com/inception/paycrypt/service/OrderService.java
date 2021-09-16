package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.model.Currency;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.utils.CurrencyCode;

/**
 * Define the signature to implement an Order Service
 *
 * @author Laura Bernal
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrderService {

    /***
     * Create order
     *
     * @param orderDto
     * @return
     */
    Order create(final OrderDto orderDto);

    /**
     * Find by id
     *
     * @param id
     * @return
     */
    Order findById(final String id);

    /**
     * Update a order
     *
     * @param orderDto
     * @param id
     * @return
     */
    Order updateOrderDate(final OrderDto orderDto, final String id );

    /**
     * Update of target currency
     *
     * @param orderDto
     * @param targetCurrencyCode
     * @return
     */
    Order updateTargetValue(final String orderId, final CurrencyCode targetCurrencyCode);

    /**
     * Update of sources currency
     *
     * param orderDto
     * @param sourceCurrencyCode
     * @return
     */
    Order updateSourceValue(final String orderId, final CurrencyCode sourceCurrencyCode);

    /**
     * Delete a order
     * @param id
     */
    void deleteOrder(String id);

}
