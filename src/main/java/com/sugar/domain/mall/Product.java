package com.sugar.domain.mall;

import com.sugar.domain.Entity;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by zhanghongqun on 2020/7/14.
 */
//@javax.persistence.Entity
//@Table(name = "sugar.product")
@Data
public class Product extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String pictureUrl;

    private String description;

    private long price;

}
