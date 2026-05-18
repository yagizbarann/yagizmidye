package com.yagizmidye.controller;

import com.yagizmidye.dto.CreateOrderRequest;
import com.yagizmidye.entity.CustomerOrder;
import com.yagizmidye.entity.OrderStatus;
import com.yagizmidye.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public CustomerOrder createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }
    @GetMapping
    public List<CustomerOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public CustomerOrder getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}/status")
    public CustomerOrder updateOrderStatus(
            @PathVariable Long id,
            @RequestParam OrderStatus status
    ) {
        return orderService.updateOrderStatus(id, status);
    }
}