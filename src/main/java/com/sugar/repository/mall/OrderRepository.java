package com.sugar.repository.mall;

import com.sugar.domain.mall.Order;
import com.sugar.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by zhanghongqun on 2020/7/14.
 */
//@Repository
public class OrderRepository extends BaseJpaRepository<Order, Long> {

    public OrderRepository(EntityManager em) {
        super(Order.class, em);
    }


}
