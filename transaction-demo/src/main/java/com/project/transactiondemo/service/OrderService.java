package com.project.transactiondemo.service;

import com.project.transactiondemo.dto.OrderRequest;
import com.project.transactiondemo.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
