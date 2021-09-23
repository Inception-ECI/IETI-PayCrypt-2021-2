package com.inception.paycrypt.repository;

import java.util.Optional;

import com.inception.paycrypt.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoDB transaction repository
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TransactionRepository extends MongoRepository<Transaction, String> {

	Optional<Transaction> findByOrderId(String orderId);

}
