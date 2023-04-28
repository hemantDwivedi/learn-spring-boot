package com.project.transactiondemo.service.impl;

import com.project.transactiondemo.dto.OrderRequest;
import com.project.transactiondemo.dto.OrderResponse;
import com.project.transactiondemo.entity.Order;
import com.project.transactiondemo.entity.Payment;
import com.project.transactiondemo.exception.PaymentException;
import com.project.transactiondemo.repository.OrderRepository;
import com.project.transactiondemo.repository.PaymentRepository;
import com.project.transactiondemo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService
{
    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;
    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("IN_PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);
        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("This card type not supported");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
