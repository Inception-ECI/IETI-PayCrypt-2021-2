package com.inception.paycrypt.repository;

import java.util.Optional;

import com.inception.paycrypt.model.PaymentMethod;
import com.inception.paycrypt.utils.CurrencyCode;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoDB Payment Method Repository
 *
 * @author Guillermo Castro (Guillermo.Castro@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public interface PaymentMethodRepository extends MongoRepository<PaymentMethod, String> {

	Optional<PaymentMethod> findBySourceCurrencyCodeAndTargetCurrencyCode(CurrencyCode sourceCurrencyCode, CurrencyCode targetCurrencyCode);
}
