package com.inception.paycrypt.repository;

import com.inception.paycrypt.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Order Repository
 *
 * @author laura Bernal
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrderRepository extends MongoRepository<Order, String> {
}
