package com.sugar.infrastructure.dto.mall;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by zhanghongqun on 2020/7/14.
 */

@Data
public class OrderDto {

    private long id;

    private long total;

    private long userId;
}
