package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    Order create(OrderDto orderDto);

    Order findById(String id);
}
