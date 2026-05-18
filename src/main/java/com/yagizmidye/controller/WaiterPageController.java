package com.yagizmidye.controller;

import com.yagizmidye.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}