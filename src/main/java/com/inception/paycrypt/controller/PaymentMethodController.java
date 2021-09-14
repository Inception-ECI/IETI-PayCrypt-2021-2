package com.inception.paycrypt.controller;

import com.inception.paycrypt.dto.PaymentMethodDto;
import com.inception.paycrypt.model.PaymentMethod;
import com.inception.paycrypt.service.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Payment Method Controller
 *
 * @author Guillermo Castro (guillermo.castro@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController()
@RequestMapping("/v1/paymentmethod")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentMethodController {

    /**
     * The {@link PaymentMethodService}
     */
    private final PaymentMethodService paymentMethodService;

    /**
     * Post create endpoint
     *
     * @param paymentMethodDto The {@link PaymentMethodDto} to be saved
     * @return The {@link PaymentMethod} saved in the server
     */
    @PostMapping
    public ResponseEntity<PaymentMethod> create(@RequestBody PaymentMethodDto paymentMethodDto) {

        return ResponseEntity.ok(paymentMethodService.create(paymentMethodDto));
    }

    /**
     * Put update endpoint
     *
     * @param paymentMethodDto The {@link PaymentMethodDto} to be updated
     * @param id               The {@link PaymentMethod} id to be updated
     * @return The {@link PaymentMethod} after being updated
     */
    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethod> update(@RequestBody PaymentMethodDto paymentMethodDto, @PathVariable String id) {

        return ResponseEntity.ok(paymentMethodService.update(paymentMethodDto, id));
    }

    /**
     * Delete endpoint
     *
     * @param id The {@link PaymentMethod} to be Delete
     * @return The {@link PaymentMethod} after being Delete
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> Delete(@PathVariable String id) {
        paymentMethodService.deleteById(id);
        return ResponseEntity.ok(true);
    }


}
