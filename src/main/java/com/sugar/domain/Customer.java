package com.sugar.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 客户
 */
@javax.persistence.Entity
@Table(name = "sugar.customer")
@Data
public class Customer extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;
    private String headImg;
    private String openid;

    public static Customer createByOpenid(String openid) {
        Customer customer = new Customer();
        customer.setOpenid(openid);
        return customer;
    }
}
