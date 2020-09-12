package com.sugar.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sugar.infrastructure.WxProps;
import com.sugar.infrastructure.cache.TokenCache;
import com.sugar.infrastructure.client.WXClient;
import com.sugar.infrastructure.dto.WxJsConfigDto;
import com.sugar.infrastructure.params.MenuParams;
import com.sugar.infrastructure.utils.JsonUtils;
import com.sugar.infrastructure.utils.WXSignUtils;
import com.sugar.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Created by zhanghongqun on 2020/6/14.
 */
@Service
@Slf4j
public class WXService {

    final WXClient wxClient;
    final ObjectMapper objectMapper;
    final CustomerRepository customerRepository;
    final WxProps wxProps;

    public WXService(WXClient wxClient, ObjectMapper objectMapper, CustomerRepository customerRepository, WxProps wxProps) {
        this.wxClient = wxClient;
        this.objectMapper = objectMapper;
        this.customerRepository = customerRepository;
        this.wxProps = wxProps;
    }

    /**
     * 根据授权CODE 获取用户ID
     */
    public String auth(String code) {
        Map<String, String> params = new HashMap<>();
        params.put("appid", wxProps.getAppId());
        params.put("secret", wxProps.getAppsecret());
        params.put("code", code);
        params.put("grant_type", "authorization_code");
        Map<String, Object> result = wxClient.getAuthToken(params);
        log.info("auth  " + JSON.toJSONString(result));
        String openid = result.get("openid").toString();
        return openid;
    }

    public WxJsConfigDto signJsConfig(String url) {
        log.info(url + "   *****************************");
        WxJsConfigDto config = new WxJsConfigDto();
        config.setAppid(wxProps.getAppId());
        long timestamp = System.currentTimeMillis() / 1000;
        String nonceStr = UUID.randomUUID().toString().replace("-", "");
        config.setNonceStr(nonceStr);
        config.setTimestamp(timestamp);
        String jsToken = getJsToken();
        String signString = "jsapi_ticket=" + jsToken + "&noncestr=" + nonceStr +
                "&timestamp=" + timestamp + "&url=" + url;
        config.setSignature(WXSignUtils.sign(signString));
        config.setJsapi_ticket(jsToken);
        return config;
    }


    public String getJsToken() {
        Map<String, String> params = new HashMap<>();
        params.put("access_token", TokenCache.getInstance().getValue());
        params.put("type", "jsapi");
        Map<String, Object> result = wxClient.getJsToken(params);
        log.info(JSON.toJSONString(result));
        String ticket = result.get("ticket").toString();
        return ticket;
    }

    public Map<String, Object> getUserInfo(String openid) {
        Map<String, String> params = new HashMap<>();
        params.put("access_token", TokenCache.getInstance().getValue());
        params.put("openid", openid);
        params.put("lang", "zh_CN");
        Map<String, Object> result = wxClient.getUserInfo(params);
        return result;
    }


    public void createMenu() {
        MenuParams menuParams = new MenuParams();
        /*
        * 活动中心一级菜单
        * **/
        MenuParams.Button promotion = new MenuParams.Button();
        promotion.setType("click");
        promotion.setName("活动中心");
        promotion.setKey("promotion");

        /*
        * 活动中心二级菜单
        * **/
        MenuParams.Button promotion_subButton_1 = new MenuParams.Button();
        promotion_subButton_1.setType("view");
        promotion_subButton_1.setName("天猫超级买家秀");
        promotion_subButton_1.setUrl("http://app.sugar3.shop");
        promotion.setSub_button(Arrays.asList(promotion_subButton_1));


        menuParams.setButton(Arrays.asList(promotion));
        Map<String, Object> result = wxClient.createMenu(TokenCache.getInstance().getValue(), menuParams);
        log.info(JsonUtils.toString(result));
    }
}
