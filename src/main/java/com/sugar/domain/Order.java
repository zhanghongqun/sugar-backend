package com.sugar.domain;

import com.sugar.infrastructure.enums.OrderSource;
import com.sugar.infrastructure.enums.OrderStatus;
import com.sugar.infrastructure.enums.RefundStatus;
import lombok.Data;

/**
 * Created by zhanghongqun on 2020/8/23.
 */
@Data
public class Order extends Entity {
    private Long id;
    private Long processId;
    private String reward;
    private OrderSource source = OrderSource.TM;
    private RefundStatus refundStatus = RefundStatus.UN;
    private OrderStatus status = OrderStatus.AUDIT;
    private Long customerId;

    public void pass() {
        status = OrderStatus.COMPLETE;
    }
}
