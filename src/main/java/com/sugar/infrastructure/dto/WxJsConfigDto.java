package com.sugar.infrastructure.dto;

import lombok.Data;

/**
 * Created by zhanghongqun on 2020/7/8.
 */
@Data
public class WxJsConfigDto {
    private String appid;
    private String nonceStr;
    private String signature;
    private long timestamp;
    private String jsapi_ticket;
}
