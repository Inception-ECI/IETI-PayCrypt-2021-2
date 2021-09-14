package com.inception.paycrypt.repository;

import com.inception.paycrypt.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
