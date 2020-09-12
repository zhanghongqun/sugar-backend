package com.sugar.infrastructure.client;

import com.sugar.infrastructure.params.MenuParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by zhanghongqun on 2020/6/14.
 */
@FeignClient(name = "wx", url = "https://api.weixin.qq.com/")
public interface WXClient {
    @GetMapping("cgi-bin/token")
    Map<String, Object> getToken(@RequestParam Map<String, String> params);

    @PostMapping("cgi-bin/menu/create")
    Map<String, Object> createMenu(@RequestParam("access_token") String accessToken, @RequestBody MenuParams menuParams);


    @GetMapping("sns/oauth2/access_token")
    Map<String, Object> getAuthToken(@RequestParam Map<String, String> params);

    @GetMapping("cgi-bin/ticket/getticket")
    Map<String, Object> getJsToken(@RequestParam Map<String, String> params);

    @GetMapping("cgi-bin/user/info")
    Map<String,Object> getUserInfo(@RequestParam Map<String, String> params);
}
