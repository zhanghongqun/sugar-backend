package com.sugar.controller.app;

import com.sugar.infrastructure.dto.CustomerDto;
import com.sugar.service.CustomerService;
import com.sugar.service.WXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhanghongqun on 2020/6/29.
 */
@RequestMapping("app/customer")
@RestController
public class AppCustomerController {
    @Autowired
    CustomerService wxService;

    @GetMapping("auth/{code}")
    public CustomerDto auth(@PathVariable String code) {
        return wxService.auth(code);
    }

    @GetMapping("{id}")
    public CustomerDto get(@PathVariable Long id) {
        return wxService.get(id);
    }

}
