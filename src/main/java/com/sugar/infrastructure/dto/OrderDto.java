package com.sugar.infrastructure.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Created by zhanghongqun on 2020/8/23.
 */
@Data
@Builder
public class OrderDto {
    private Long id;
    private Long processId;
    private String reward;
    private String source;
    private String refundStatus;
    private String status;
    private Date create;
    private Long customerId;
}
