package com.sugar.infrastructure.dto.mall;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by zhanghongqun on 2020/7/14.
 */
@Data
public class ProductDto {
    private long id;

    private String name;

    private String pictureUrl;

    private String description;

    private long price;
}
