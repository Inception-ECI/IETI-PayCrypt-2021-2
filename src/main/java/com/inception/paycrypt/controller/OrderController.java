package com.inception.paycrypt.controller;
import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.service.OrderService;
import com.inception.paycrypt.utils.CurrencyCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;
import static com.inception.paycrypt.utils.UserRoles.*;

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
     * Orderservice
     */
    private final OrderService orderService;

    /**
     * Post create endpoint
     *
     * @param orderDto to be saved
     * @return Order
     */
    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderDto orderDto){
        try{
            return new ResponseEntity<>(orderService.create(orderDto),HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update of the information
     *
     * @param orderDto
     * @param id
     * @return order update
     */
    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@RequestBody OrderDto orderDto, @PathVariable String id) {
        return ResponseEntity.ok(orderService.updateOrderDate(orderDto,id));
    }

    /**
     * Delete of the order
     *
     * @param id
     * @return delete response
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok(true);
    }

    /**
     * Update to order by merchant
     *
     * @param orderDto
     * @param orderId
     * @return update to targetCurrency
     */
    @PutMapping("/targetCurrencyCode/{orderId}")
    @RolesAllowed(MERCHANT)
    public ResponseEntity<Order> updateTargetValue(@RequestBody OrderDto orderDto, @PathVariable String orderId) {
        return ResponseEntity.ok(orderService.updateTargetValue(orderId,orderDto.getTargetCurrencyCode()));
    }

    /**
     * Update to order by user
     *
     * @param orderDto
     * @param orderId
     * @return update to sourceCurrency
     */
    @PutMapping("/sourceCurrencyCode/{orderId}")
    @RolesAllowed(USER)
    public ResponseEntity<Order> updateSourceValue(@RequestBody OrderDto orderDto, @PathVariable String orderId) {
        return ResponseEntity.ok(orderService.updateSourceValue(orderId,orderDto.getSourceCurrencyCode()));
    }

}
