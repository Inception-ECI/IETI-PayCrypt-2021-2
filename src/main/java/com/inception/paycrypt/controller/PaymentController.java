package com.inception.paycrypt.controller;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.service.PaymentService;
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
@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentController {

    /**
     * The {@link PaymentService}
     */
    private final PaymentService paymentService;

    /**
     * Endpoint to create a payment link
     *
     * @param orderDto The order to be paid with the payment link
     * @return The payment Token for the pay endpoint
     * @throws IOException When can't convert between currencies
     */
    @PostMapping("/link")
    public ResponseEntity<String> createPaymentLink(@RequestBody OrderDto orderDto, @RequestHeader("Authorization") String authorization) throws IOException {

        return ResponseEntity.ok(paymentService.generateToken(authorization.split(" ")[1], orderDto));
    }

    @PostMapping("/pay")
    public ResponseEntity<Boolean> payOrder(@RequestBody OrderDto orderDto) {

        return ResponseEntity.ok(paymentService.payOrder(orderDto.getPaymentToken()));
    }

    @PostMapping("/update-source")
    public ResponseEntity<String> updateSource(@RequestBody OrderDto orderDto) throws IOException {

        return ResponseEntity.ok(paymentService.updateSourceCurrency(orderDto.getId(), orderDto.getSourceCurrencyCode()));
    }
}
