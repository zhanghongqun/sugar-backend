package com.sugar.service.mall;

import com.sugar.infrastructure.mapper.mall.ProductMapper;
import com.sugar.infrastructure.params.mall.ProductParams;
import com.sugar.repository.mall.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhanghongqun on 2020/7/14.
 */
//@Service
public class ProductService {
    final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(ProductParams productParams) {
        productRepository.save(ProductMapper.map(productParams));
    }
}
