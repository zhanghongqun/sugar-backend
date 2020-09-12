package com.sugar.controller.mall;

import com.sugar.infrastructure.dto.mall.ProductDto;
import com.sugar.infrastructure.params.mall.ProductParams;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhanghongqun on 2020/7/14.
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @PostMapping
    public void create(@RequestBody ProductParams productParams) {

    }

    @GetMapping("{id}")
    public ProductDto get(String id) {
        return null;
    }

    @GetMapping("list")
    public Page<ProductDto> list() {
        return null;
    }
}
