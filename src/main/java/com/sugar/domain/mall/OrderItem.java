package com.sugar.domain.mall;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zhanghongqun on 2020/7/14.
 */
//@javax.persistence.Entity
//@Table(name = "sugar.order.item")
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long productId;

    private int count;

    private long salesPrice;


}
