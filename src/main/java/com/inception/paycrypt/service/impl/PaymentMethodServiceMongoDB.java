package com.inception.paycrypt.service.impl;

import java.util.Optional;

import com.inception.paycrypt.dto.PaymentMethodDto;
import com.inception.paycrypt.exception.PaymentMethodServiceException;
import com.inception.paycrypt.model.PaymentMethod;
import com.inception.paycrypt.repository.PaymentMethodRepository;
import com.inception.paycrypt.service.PaymentMethodService;
import com.inception.paycrypt.utils.CurrencyCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Define the signature to implement a {@link PaymentMethodService} using MongoDB
 *
 * @author Guillermo Castro (guillermo.castro@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("paymentMethodServiceMongoDB")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentMethodServiceMongoDB implements PaymentMethodService {

	/**
	 * MongoDB repository where the information is going to be extracted
	 */
	private final PaymentMethodRepository paymentMethodRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentMethod create(PaymentMethodDto paymentMethodDto) {

		return paymentMethodRepository.save(new PaymentMethod(paymentMethodDto));
	}

	@Override
	public PaymentMethod findBySourceAndTargetCurrencyCode(final CurrencyCode source, final CurrencyCode target) {

		Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository
				.findBySourceCurrencyCodeAndTargetCurrencyCode(source, target);

		if (optionalPaymentMethod.isPresent()) {

			return optionalPaymentMethod.get();
		}

		throw new PaymentMethodServiceException(PaymentMethodServiceException.PAYMENT_METHOD_NOT_FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentMethod update(PaymentMethodDto paymentMethodDto, String id) {

		Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findById(id);

		if (optionalPaymentMethod.isPresent()) {
			PaymentMethod paymentMethod = optionalPaymentMethod.get();
			paymentMethod.update(paymentMethodDto);
			paymentMethodRepository.save(paymentMethod);
			return paymentMethod;
		}

		throw new PaymentMethodServiceException(PaymentMethodServiceException.PAYMENT_METHOD_NOT_FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(String id) {

		if (!paymentMethodRepository.existsById(id)) {

			throw new PaymentMethodServiceException(PaymentMethodServiceException.PAYMENT_METHOD_NOT_FOUND);
		}
		paymentMethodRepository.deleteById(id);
	}
}
