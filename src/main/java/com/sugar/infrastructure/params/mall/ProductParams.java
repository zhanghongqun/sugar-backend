package com.sugar.infrastructure.params.mall;

import lombok.Data;

/**
 * Created by zhanghongqun on 2020/7/14.
 */
@Data
public class ProductParams {
    private long id;

    private String name;

    private String pictureUrl;

    private String description;

    private long price;
}
