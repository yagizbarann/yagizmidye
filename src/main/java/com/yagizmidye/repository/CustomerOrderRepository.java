package com.yagizmidye.repository;

import com.yagizmidye.entity.CustomerOrder;
import com.yagizmidye.entity.OrderStatus;
import com.yagizmidye.entity.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    List<CustomerOrder> findByStatus(OrderStatus status);

    List<CustomerOrder> findByOrderType(OrderType orderType);

    List<CustomerOrder> findByTableNumber(String tableNumber);
}