package com.inception.paycrypt.controller;

import static com.inception.paycrypt.utils.UserRoles.USER;

import java.io.IOException;
import javax.annotation.security.RolesAllowed;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<String> createPaymentLink(@RequestBody OrderDto orderDto) throws IOException {

		return ResponseEntity.ok(paymentService.generateToken(orderDto));
	}

	/**
	 * Endpoint to pay an order
	 *
	 * @param orderDto The token of the order to pay
	 * @return if the order was paid successfully
	 */
	@PostMapping("/link/pay")
	public ResponseEntity<Boolean> payLink(@RequestBody OrderDto orderDto) {

		return ResponseEntity.ok(paymentService.payLink(orderDto.getPaymentToken()));
	}

	@PostMapping("/pay")
	@RolesAllowed(USER)
	public ResponseEntity<Boolean> payOrder(@RequestHeader("Authorization") String authorization, @RequestBody OrderDto orderDto) {

		return ResponseEntity.ok(paymentService.payOrder(authorization.split(" ")[1], orderDto.getPaymentToken()));
	}
}
