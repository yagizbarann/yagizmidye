package com.yagizmidye.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {

    @NotBlank(message = "Müşteri adı boş bırakılamaz")
    private String customerName;

    private String tableNumber;

    @NotEmpty(message = "Sipariş en az bir ürün içermelidir")
    @Valid
    private List<OrderItemRequest> items;

    @NotBlank(message = "Sipariş tipi boş bırakılamaz")
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