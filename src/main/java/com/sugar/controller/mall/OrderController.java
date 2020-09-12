package com.sugar.controller.mall;

import com.sugar.infrastructure.params.mall.OrderParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhanghongqun on 2020/7/14.
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @PostMapping
    public void create(@RequestBody OrderParams orderParams) {

    }
}
