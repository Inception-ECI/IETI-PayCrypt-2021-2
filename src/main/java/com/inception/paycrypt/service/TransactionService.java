package com.inception.paycrypt.service;

import com.inception.paycrypt.model.Transaction;

public interface TransactionService {

	Transaction create(Transaction transaction);

	Transaction findByOrder(String orderId);
}
