package com.yagizmidye.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {

    private String customerName;

    private String tableNumber;

    private List<OrderItemRequest> items;
}