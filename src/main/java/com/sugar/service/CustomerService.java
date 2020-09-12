package com.sugar.service;

import com.google.common.collect.Lists;
import com.sugar.domain.Customer;
import com.sugar.infrastructure.dto.CustomerDto;
import com.sugar.infrastructure.enums.ProcessStatus;
import com.sugar.infrastructure.mapper.CustomerMapper;
import com.sugar.infrastructure.mapper.ProcessMapper;
import com.sugar.repository.CustomerRepository;
import com.sugar.repository.task.ProcessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by zhanghongqun on 2020/7/5.
 */
@Service
@Slf4j
public class CustomerService {

    final WXService wxService;
    final CustomerRepository customerRepository;
    final TaskService taskService;
    final ProcessRepository processRepository;

    @Autowired
    public CustomerService(WXService wxService, CustomerRepository customerRepository, TaskService taskService, ProcessRepository processRepository) {
        this.wxService = wxService;
        this.customerRepository = customerRepository;
        this.taskService = taskService;
        this.processRepository = processRepository;
    }

    public CustomerDto get(Long customerId) {
        Customer customer = customerRepository.get(customerId);
        return buildTaskInfo(customer);
    }

    public CustomerDto auth(String code) {
        String openid = wxService.auth(code);
        log.info("openid " + openid);
        return getOrCreate(openid);
    }

    public CustomerDto getOrCreate(String openid) {
        Customer customer = customerRepository.getByOpenId(openid);
        if (customer == null) {
            customer = Customer.createByOpenid(openid);
            Map<String, Object> result = wxService.getUserInfo(openid);
            customer.setName(result.get("nickname").toString());
            customer.setHeadImg(result.get("headimgurl").toString());
            customer.setCity(result.get("city").toString());
            customerRepository.save(customer);
        }
        return buildTaskInfo(customer);
    }

    private CustomerDto buildTaskInfo(Customer customer) {
        CustomerDto customerDto = CustomerMapper.map(customer);
        customerDto.setProcess(ProcessMapper.map(taskService.getDoing(customer.getId())));
        customerDto.setTaskCount(processRepository.getByCustomerAndStatuses(customer.getId(), Lists.newArrayList(ProcessStatus.COMPLETE)).size());
        return customerDto;
    }
}
