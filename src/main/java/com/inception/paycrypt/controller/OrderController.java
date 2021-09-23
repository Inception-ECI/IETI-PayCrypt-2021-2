package com.inception.paycrypt.controller;

import static com.inception.paycrypt.utils.UserRoles.MERCHANT;
import static com.inception.paycrypt.utils.UserRoles.USER;

import java.io.IOException;
import javax.annotation.security.RolesAllowed;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Controller
 *
 * @author Laura Bernal
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

	/**
	 * Order service
	 */
	private final OrderService orderService;

	/**
	 * Post create endpoint
	 *
	 * @param orderDto to be saved
	 * @return Order
	 */
	@PostMapping
	@RolesAllowed(MERCHANT)
	public ResponseEntity<Order> create(@RequestBody OrderDto orderDto) throws IOException {

		return ResponseEntity.ok(orderService.create(orderDto));
	}

	/**
	 * Update of the information
	 *
	 * @param orderId The id of the Order
	 * @return order update
	 */
	@PutMapping("/{orderId}")
	@RolesAllowed(MERCHANT)
	public ResponseEntity<Order> updateExpirationDate(@PathVariable String orderId) {

		return ResponseEntity.ok(orderService.updateOrderDate(orderId));
	}

	/**
	 * Update to order by merchant
	 *
	 * @param orderDto The {@link OrderDto} with the new info
	 * @param orderId  The order id
	 * @return update to targetCurrency
	 */
	@PutMapping("/target/{orderId}")
	@RolesAllowed(MERCHANT)
	public ResponseEntity<Order> updateTargetValue(@RequestBody OrderDto orderDto, @PathVariable String orderId) throws IOException {

		return ResponseEntity.ok(orderService.updateTargetValue(orderId, orderDto));
	}

	/**
	 * Update to order by user
	 *
	 * @param orderDto The {@link OrderDto} with the new info
	 * @param orderId  The order id
	 * @return update to sourceCurrency
	 */
	@PutMapping("/source/{orderId}")
	@RolesAllowed(USER)
	public ResponseEntity<Order> updateSourceValue(@RequestBody OrderDto orderDto, @PathVariable String orderId) throws IOException {

		return ResponseEntity.ok(orderService.updateSourceValue(orderId, orderDto));
	}

}
