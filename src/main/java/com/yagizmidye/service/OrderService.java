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
import com.yagizmidye.repository.RestaurantTableRepository;
import com.yagizmidye.entity.RestaurantTable;


@Service
public class OrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final ProductRepository productRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    public List<RestaurantTable> getAllTables() {
        return restaurantTableRepository.findAll();
    }

    public OrderService(CustomerOrderRepository customerOrderRepository,
                        ProductRepository productRepository,
                        RestaurantTableRepository restaurantTableRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.productRepository = productRepository;
        this.restaurantTableRepository = restaurantTableRepository;

    }

    public CustomerOrder createOrder(CreateOrderRequest request) {

        CustomerOrder order = new CustomerOrder();

        order.setCustomerName(request.getCustomerName());
        order.setTableNumber(request.getTableNumber());
        order.setCreatedDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        OrderType orderType = OrderType.valueOf(request.getOrderType());

        order.setOrderType(orderType);
        order.setPhone(request.getPhone());
        order.setAddress(request.getAddress());
        order.setNote(request.getNote());
        order.setPaymentMethod(request.getPaymentMethod());
        order.setCardHolderName(request.getCardHolderName());

        order.setCardNumber(request.getCardNumber());

        order.setCardExpiry(request.getCardExpiry());

        order.setCardCvv(request.getCardCvv());

        if (orderType == OrderType.TABLE) {

            RestaurantTable table = restaurantTableRepository.findByTableNumber(request.getTableNumber())
                    .orElseThrow(() -> new RuntimeException("Table not found"));

            table.setStatus(TableStatus.OCCUPIED);
            restaurantTableRepository.save(table);
        }

        List<OrderItem> orderItems = new ArrayList<>();

        double totalPrice = 0;

        for (OrderItemRequest itemRequest : request.getItems()) {

            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem orderItem = new OrderItem();

            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.getQuantity());

            double discount = product.getDiscountRate() != null
                    ? product.getDiscountRate()
                    : 0.0;

            double discountedPrice =
                    product.getPrice() - (product.getPrice() * discount / 100);

            double itemPrice =
                    discountedPrice * itemRequest.getQuantity();

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
        if ((status == OrderStatus.SERVED || status == OrderStatus.CANCELLED)
                && order.getOrderType() == OrderType.TABLE) {

            RestaurantTable table = restaurantTableRepository.findByTableNumber(order.getTableNumber())
                    .orElseThrow(() -> new RuntimeException("Table not found"));

            table.setStatus(TableStatus.EMPTY);
            restaurantTableRepository.save(table);
        }

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
    public List<CustomerOrder> getActiveTableOrders() {
        return customerOrderRepository.findAll()
                .stream()
                .filter(order -> order.getStatus() != OrderStatus.SERVED)
                .filter(order -> order.getStatus() != OrderStatus.CANCELLED)
                .toList();
    }
}
