package com.sugar.service;

import com.sugar.domain.Order;
import com.sugar.infrastructure.enums.OrderStatus;
import com.sugar.repository.task.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhanghongqun on 2020/8/26.
 */
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void audit(Long orderId, OrderStatus status) {
        Order order = orderRepository.get(orderId);
        if (status.getCode() == OrderStatus.COMPLETE.getCode()) {
            order.pass();
        }
        orderRepository.save(order);
    }
}
