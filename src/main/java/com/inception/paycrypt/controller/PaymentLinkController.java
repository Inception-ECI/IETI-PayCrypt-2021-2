package com.inception.paycrypt.controller;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.service.PaymentLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Payment link Controller
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/payment")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentLinkController {

    /**
     * The {@link PaymentLinkService}
     */
    private final PaymentLinkService paymentLinkService;

    /**
     * Endpoint to create a payment link
     *
     * @param orderDto The order to be paid with the payment link
     * @return The payment Token for the pay endpoint
     * @throws IOException When can't convert between currencies
     */
    @PostMapping
    public ResponseEntity<String> create(@RequestBody OrderDto orderDto) throws IOException {

        return ResponseEntity.ok(paymentLinkService.generateToken(orderDto));
    }

    /**
     * Endpoint to pay an order
     *
     * @param orderDto The token of the order to pay
     * @return if the order was paid successfully
     */
    @PostMapping("/pay")
    public ResponseEntity<Boolean> pay(@RequestBody OrderDto orderDto) {

        return ResponseEntity.ok(paymentLinkService.pay(orderDto.getPaymentToken()));
    }
}
