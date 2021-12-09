package com.inception.paycrypt.service.impl;

import java.util.List;
import java.util.Optional;

import com.inception.paycrypt.exception.OrderServiceException;
import com.inception.paycrypt.exception.UserServiceException;
import com.inception.paycrypt.model.Transaction;
import com.inception.paycrypt.repository.TransactionRepository;
import com.inception.paycrypt.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("transactionServiceMongoDB")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionServiceMongoDB implements TransactionService {

	private final TransactionRepository transactionRepository;

	@Override
	public Transaction create(final Transaction transaction) {

		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction findByOrder(final String orderId) {

		Optional<Transaction> optionalTransaction = transactionRepository.findByOrderId(orderId);

		if (optionalTransaction.isPresent()) {

			return optionalTransaction.get();
		}

		throw new OrderServiceException(OrderServiceException.ORDER_TRANSACTION_NOT_FOUND);
	}

	@Override
	public List<Transaction> getAllTransactionsByUserid(String sourceUserId) {
		Optional<List<Transaction>> optionalTransactions = transactionRepository.findAllBySourceUserIdOrTargetUserId(sourceUserId, sourceUserId);

		if (optionalTransactions.isPresent()) {

			return optionalTransactions.get();
		}

		throw new OrderServiceException(OrderServiceException.ORDER_TRANSACTION_NOT_FOUND);
	}

}
