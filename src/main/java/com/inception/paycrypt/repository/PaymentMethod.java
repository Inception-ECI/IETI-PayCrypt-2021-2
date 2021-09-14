package com.inception.paycrypt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoDB Payment Method Repository
 *
 * @author Guillermo Castro (Guillermo.Castro@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public interface PaymentMethod extends MongoRepository<PaymentMethod,String> {
}
