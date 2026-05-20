package com.yagizmidye.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {

    private String customerName;

    private String tableNumber;

    private List<OrderItemRequest> items;

    private String orderType;

    private String phone;

    private String address;

    private String note;

    private String paymentMethod;

    private String cardHolderName;

    private String cardNumber;

    private String cardExpiry;

    private String cardCvv;
}