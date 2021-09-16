package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.model.Order;
import org.springframework.stereotype.Service;

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
    Order create(OrderDto orderDto);

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
}
