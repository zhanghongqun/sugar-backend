package com.sugar.infrastructure.mapper;

import com.sugar.domain.Order;
import com.sugar.infrastructure.dto.OrderDto;

/**
 * Created by zhanghongqun on 2020/8/23.
 */
public class OrderMapper {

    public static OrderDto map(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .processId(order.getProcessId())
                .reward(order.getReward())
                .refundStatus(order.getRefundStatus().getMessage())
                .status(order.getStatus().getMessage())
                .source(order.getSource().getMessage())
                .build();
    }
}
