package com.sugar.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by zhanghongqun on 2020/7/11.
 */
@FeignClient(name = "edb", url = "http://vm3235.edb01.com/rest/index.aspx")
public interface EDBClient {

    @GetMapping
    Map<String, String> get(@RequestParam Map<String, ?> params);

}
