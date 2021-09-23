package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.utils.CurrencyCode;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Order services
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface OrderService {

    /**
     * Create an order in database
     *
     * @param orderDto The data of the order to be created
     * @return The created order
     */
    Order create(OrderDto orderDto) throws IOException;

    /**
     * Upate an order in database
     *
     * @param order The new data of the order to be updated
     * @return The order returned from the database
     */
    Order update(Order order);

    /**
     * Finds an order in database by id
     *
     * @param id The id of the order
     * @return The order found in database
     */
    Order findById(String id);

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
