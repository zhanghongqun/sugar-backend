package com.sugar.infrastructure.mapper.mall;

import com.sugar.domain.mall.Product;
import com.sugar.infrastructure.params.mall.ProductParams;

/**
 * Created by zhanghongqun on 2020/7/14.
 */
public class ProductMapper {

    public static Product map(ProductParams productDto) {
        Product product = new Product();
        product.setDescription(product.getDescription());
        product.setName(productDto.getName());
        product.setPictureUrl(productDto.getPictureUrl());
        product.setPrice(productDto.getPrice());
        return product;
    }
}
