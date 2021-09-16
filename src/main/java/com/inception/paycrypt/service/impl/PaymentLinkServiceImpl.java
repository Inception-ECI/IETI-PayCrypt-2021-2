package com.inception.paycrypt.service.impl;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.dto.RequestConversionDto;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.service.OrderService;
import com.inception.paycrypt.service.PaymentLinkService;
import com.inception.paycrypt.utils.OrderState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * Payment link MongoDB service
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("paymentLinkService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentLinkServiceImpl implements PaymentLinkService {

    /**
     * The {@link OrderService}
     */
    private final OrderService orderService;

    /**
     * The {@link ConversionServiceImpl} to convert currencies
     */
    private final ConversionServiceImpl conversionService;

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToken(OrderDto orderDto) throws IOException {

        RequestConversionDto requestConversion = new RequestConversionDto();
        requestConversion.setSourceCurrency(orderDto.getTargetCurrencyCode());
        requestConversion.setTargetCurrency(orderDto.getSourceCurrencyCode());
        requestConversion.setSourceValue(Double.parseDouble(orderDto.getTargetValue()));
        orderDto.setSourceValue(conversionService.conversionCurrency(requestConversion).getValue().toString());
        orderDto.setOrderState(OrderState.IN_PROGRESS);
        Order order = orderService.create(orderDto);

        return order.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean pay(String paymentToken) {

        boolean canPay = false;
        Order order = orderService.findById(paymentToken);
        if (order.getOrderState().equals(OrderState.IN_PROGRESS) && order.getExpirationDate().after(new Date())) {

            order.setOrderState(OrderState.PAID);
            orderService.update(order);
            canPay = true;
        }

        return canPay;
    }
}
