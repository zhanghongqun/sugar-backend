package com.sugar.infrastructure.params.mall;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhanghongqun on 2020/7/14.
 */

@Data
public class OrderParams {
    @NotEmpty
    private List<OrderItemParams> items;

    private long total;
    @NotEmpty
    private long userId;

    @Data
    public static class OrderItemParams {
        @NotEmpty
        private long productId;
        @NotEmpty
        private int count;
    }
}
