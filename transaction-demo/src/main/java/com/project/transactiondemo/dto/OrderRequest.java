package com.project.transactiondemo.dto;

import com.project.transactiondemo.entity.Order;
import com.project.transactiondemo.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
