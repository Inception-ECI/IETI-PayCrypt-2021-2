package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Service for payment link creation and usage
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface PaymentService {

    /**
     * Generate a token to be used in the payment endpont
     *
     * @param orderDto The order this token will be related to
     * @return The generated token
     * @throws IOException When can't convert currencies
     */
    String generateToken(OrderDto orderDto) throws IOException;

    /**
     * Pay an order with a payment token
     *
     * @param paymentToken The token related to the order
     * @return if the order could be paid successfully
     */
    boolean payLink(String paymentToken);

    boolean payOrder(String token, String orderId);
}
