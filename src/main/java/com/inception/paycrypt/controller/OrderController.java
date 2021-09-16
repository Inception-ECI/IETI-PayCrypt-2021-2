package com.inception.paycrypt.controller;

import com.inception.paycrypt.dto.CurrencyDto;
import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.dto.UserDto;
import com.inception.paycrypt.model.Currency;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.model.User;
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

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderDto orderDto){
        try{
            return new ResponseEntity<>(orderService.create(orderDto),HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@RequestBody OrderDto orderDto, @PathVariable String id) {
        return ResponseEntity.ok(orderService.updateOrderDate(orderDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/{id}")
    @RolesAllowed(MERCHANT)
    public ResponseEntity<Order> updateTargetValue(@RequestBody OrderDto orderDto, @PathVariable CurrencyCode targetCurrencyCode) {
        return ResponseEntity.ok(orderService.updateTargetValue(orderDto,targetCurrencyCode));
    }

    @PutMapping("/{id}")
    @RolesAllowed(USER)
    public ResponseEntity<Order> updateSourcetValue(@RequestBody OrderDto orderDto, @PathVariable CurrencyCode sourceCurrencyCode) {
        return ResponseEntity.ok(orderService.updateTargetValue(orderDto,sourceCurrencyCode));
    }

}
