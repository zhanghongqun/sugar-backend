package com.sugar.controller.app;

import com.sugar.infrastructure.dto.OrderDto;
import com.sugar.repository.task.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhanghongqun on 2020/8/25.
 */
@RequestMapping("app")
@RestController
public class AppOrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("orders")
    public List<OrderDto> getOrders(@RequestParam("customerId") Long customerId) {
        return orderRepository.getByCustomer(customerId, 0);
    }
}
