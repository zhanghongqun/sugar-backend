package com.sugar.domain.mall;

import com.sugar.domain.Entity;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by zhanghongqun on 2020/7/14.
 */
//@javax.persistence.Entity
//@Table(name = "sugar.order")
@Data
public class Order extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private List<OrderItem> items;

    private long total;

    private long userId;
}
