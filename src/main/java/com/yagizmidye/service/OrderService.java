package com.yagizmidye.service;

import com.yagizmidye.dto.CreateOrderRequest;
import com.yagizmidye.dto.OrderItemRequest;
import com.yagizmidye.entity.*;
import com.yagizmidye.repository.CustomerOrderRepository;
import com.yagizmidye.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final ProductRepository productRepository;

    public OrderService(CustomerOrderRepository customerOrderRepository,
                        ProductRepository productRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.productRepository = productRepository;
    }

    public CustomerOrder createOrder(CreateOrderRequest request) {

        CustomerOrder order = new CustomerOrder();

        order.setCustomerName(request.getCustomerName());
        order.setTableNumber(request.getTableNumber());
        order.setCreatedDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        List<OrderItem> orderItems = new ArrayList<>();

        double totalPrice = 0;

        for (OrderItemRequest itemRequest : request.getItems()) {

            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem orderItem = new OrderItem();

            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.getQuantity());

            double itemPrice = product.getPrice() * itemRequest.getQuantity();

            orderItem.setPrice(itemPrice);
            orderItem.setCustomerOrder(order);

            totalPrice += itemPrice;

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        order.setTotalPrice(totalPrice);

        return customerOrderRepository.save(order);
    }
    public List<CustomerOrder> getAllOrders() {
        return customerOrderRepository.findAll();
    }

    public CustomerOrder getOrderById(Long id) {
        return customerOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public CustomerOrder updateOrderStatus(Long id, OrderStatus status) {

        CustomerOrder order = getOrderById(id);

        order.setStatus(status);

        return customerOrderRepository.save(order);
    }
    public long getTotalOrderCount() {

        return customerOrderRepository.findAll()
                .stream()
                .filter(order -> order.getStatus() != OrderStatus.CANCELLED)
                .count();
    }

    public double getTotalRevenue() {

        return customerOrderRepository.findAll()
                .stream()
                .filter(order -> order.getStatus() != OrderStatus.CANCELLED)
                .mapToDouble(CustomerOrder::getTotalPrice)
                .sum();
    }

    public long getPendingOrderCount() {

        return customerOrderRepository.findAll()
                .stream()
                .filter(order -> order.getStatus() == OrderStatus.PENDING)
                .count();
    }
    public long getCancelledOrderCount() {

        return customerOrderRepository.findAll()
                .stream()
                .filter(order -> order.getStatus() == OrderStatus.CANCELLED)
                .count();
    }
}
