package com.yagizmidye.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItemRequest {

    @NotNull(message = "Ürün ID boş olamaz")
    private Long productId;

    @NotNull(message = "Adet boş olamaz")
    @Min(value = 1, message = "Adet en az 1 olmalıdır")
    private Integer quantity;
}