package com.yagizmidye.controller;

import com.yagizmidye.entity.CustomerOrder;
import com.yagizmidye.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.yagizmidye.entity.OrderStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WaiterPageController {

    private final OrderService orderService;

    public WaiterPageController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/waiter/orders")
    public String waiterOrdersPage(Model model) {
        model.addAttribute("tables", orderService.getAllTables());
        model.addAttribute("orders", orderService.getAllOrders());
        return "waiter-orders";
    }
    @PostMapping("/waiter/orders/status")
    @ResponseBody
    public CustomerOrder updateOrderStatus(
            @RequestParam Long orderId,
            @RequestParam OrderStatus status
    ) {

        return orderService.updateOrderStatus(orderId, status);
    }
    @GetMapping("/waiter/orders/count")
    @ResponseBody
    public long getOrderCount() {
        return orderService.getAllOrders().size();
    }
}