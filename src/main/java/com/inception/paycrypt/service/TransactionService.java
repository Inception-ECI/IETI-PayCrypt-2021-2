package com.inception.paycrypt.service;

import com.inception.paycrypt.model.Transaction;

import java.util.List;

public interface TransactionService {

	Transaction create(Transaction transaction);

	Transaction findByOrder(String orderId);

	List<Transaction> getAllTransactionsByUserid(String sourceUserId);

}
