package com.yagizmidye.controller;

import com.yagizmidye.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.yagizmidye.entity.OrderStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WaiterPageController {

    private final OrderService orderService;

    public WaiterPageController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/waiter/orders")
    public String waiterOrdersPage(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "waiter-orders";
    }
    @PostMapping("/waiter/orders/status")
    public String updateOrderStatus(
            @RequestParam Long orderId,
            @RequestParam OrderStatus status
    ) {

        orderService.updateOrderStatus(orderId, status);

        return "redirect:/waiter/orders";
    }
}