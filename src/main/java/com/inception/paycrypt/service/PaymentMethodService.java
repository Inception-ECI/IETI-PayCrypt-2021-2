package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.PaymentMethodDto;
import com.inception.paycrypt.model.PaymentMethod;
import org.springframework.stereotype.Service;

@Service
public interface PaymentMethodService {

    /**
     * Create a Payment Method
     *
     * @param paymentMethodDto The {@link PaymentMethodDto} to be created in the records
     * @return The Payment Method that is now in the records
     */
    PaymentMethod create(PaymentMethodDto paymentMethodDto);

    /**
     * Update a user if given the User id
     *
     * @param paymentMethodDto The {@link PaymentMethodDto} with the new information
     * @param id               The id of the {@link PaymentMethod} to be Updated
     * @return The {@link PaymentMethod} that has been Updated
     */
    PaymentMethod update(PaymentMethodDto paymentMethodDto, String id);

    /**
     * Update a user if given the User id
     *
     * @param id The id of the {@link PaymentMethod} to be Delete
     * @return The Boolean that has been Delete
     */
    void deleteById(String id);
}
