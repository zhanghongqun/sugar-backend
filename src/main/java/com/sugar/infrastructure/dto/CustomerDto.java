package com.sugar.infrastructure.dto;

import lombok.Data;

/**
 * Created by zhanghongqun on 2020/7/5.
 */
@Data
public class CustomerDto {
    private Long id;

    private String name;

    private String headImage;
    private String city;

    private String openid;

    private ProcessDto process;

    private Integer taskCount;

    private Integer point = 0;


}
