package com.sugar.repository.model;

import com.sugar.domain.Entity;
import com.sugar.domain.Order;
import com.sugar.infrastructure.dto.OrderDto;
import com.sugar.infrastructure.enums.OrderSource;
import com.sugar.infrastructure.enums.OrderStatus;
import com.sugar.infrastructure.enums.RefundStatus;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zhanghongqun on 2020/8/23.
 */
@Data
@javax.persistence.Entity
@Table(name = "sugar.order")
public class OrderDo extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long processId;
    private String reward;
    private int source;
    private int refundStatus;
    private int status;
    private Long customerId;


    public static OrderDo map(Order order) {
        OrderDo orderDo = new OrderDo();
        orderDo.setProcessId(order.getProcessId());
        orderDo.setReward(order.getReward());
        orderDo.setSource(order.getSource().getCode());
        orderDo.setRefundStatus(order.getRefundStatus().getCode());
        orderDo.setStatus(order.getStatus().getCode());
        orderDo.setCustomerId(order.getCustomerId());
        orderDo.setCreate(order.getCreate());
        return orderDo;

    }

    public Order map() {
        Order order = new Order();
        order.setProcessId(getProcessId());
        order.setReward(reward);
        order.setRefundStatus(RefundStatus.getByCode(getRefundStatus()));
        order.setSource(OrderSource.getByCode(getSource()));
        order.setStatus(OrderStatus.getByCode(getStatus()));
        order.setId(getId());
        order.setCustomerId(customerId);
        order.setCreate(create);
        return order;
    }

    public OrderDto mapTo() {
        return OrderDto.builder()
                .source(OrderSource.getByCode(source).getMessage())
                .status(OrderStatus.getByCode(status).getMessage())
                .refundStatus(RefundStatus.getByCode(refundStatus).getMessage())
                .reward(reward)
                .processId(processId)
                .id(id)
                .create(create)
                .customerId(customerId)
                .build();
    }
}
