package com.inception.paycrypt.repository;

import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


/**
 * Repository for currency
 *
 * @author laura Bernal
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrderRepository extends MongoRepository<Order, String> {

    /**
     * Method to find a Order by his id
     *
     * @param id The Order id
     * @return
     */
    Optional<Order>findByid(String id);

}
