package com.sugar.service.mall;

import com.sugar.domain.mall.Order;
import com.sugar.domain.mall.OrderItem;
import com.sugar.domain.mall.Product;
import com.sugar.infrastructure.params.mall.OrderParams;
import com.sugar.repository.CustomerRepository;
import com.sugar.repository.mall.OrderRepository;
import com.sugar.repository.mall.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zhanghongqun on 2020/7/14.
 */
//@Service
public class OrderService {

    final OrderRepository orderRepository;
    final CustomerRepository customerRepository;
    final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public void create(OrderParams orderParams) {
        Order order = new Order();
        order.setUserId(order.getUserId());
        List<OrderItem> orderItems = orderParams.getItems().stream().map(i -> createItem(i)).collect(toList());
        order.setItems(orderItems);
        order.setTotal(orderItems.stream().mapToLong(i -> i.getSalesPrice() * i.getCount()).sum());

    }


    public OrderItem createItem(OrderParams.OrderItemParams params) {
        Product product = productRepository.getOne(params.getProductId());
        OrderItem orderItem = new OrderItem();
        orderItem.setCount(params.getCount());
        orderItem.setProductId(product.getId());
        orderItem.setSalesPrice(product.getPrice());
        return orderItem;
    }
}
