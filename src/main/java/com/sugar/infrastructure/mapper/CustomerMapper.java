package com.sugar.infrastructure.mapper;

import com.sugar.domain.Customer;
import com.sugar.infrastructure.dto.CustomerDto;

/**
 * Created by zhanghongqun on 2020/7/5.
 */
public class CustomerMapper {

    public static CustomerDto map(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setOpenid(customer.getOpenid());
        customerDto.setName(customer.getName());
        customerDto.setHeadImage(customer.getHeadImg());
        customerDto.setCity(customer.getCity());
        return customerDto;
    }
}
