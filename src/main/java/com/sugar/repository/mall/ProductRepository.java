package com.sugar.repository.mall;

import com.sugar.domain.mall.Product;
import com.sugar.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by zhanghongqun on 2020/7/14.
 */
//@Repository
public class ProductRepository extends BaseJpaRepository<Product, Long> {
    public ProductRepository(EntityManager em) {
        super(Product.class, em);
    }
}
