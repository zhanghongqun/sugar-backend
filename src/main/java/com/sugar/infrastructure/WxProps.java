package com.sugar.infrastructure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhanghongqun on 2020/6/14.
 */
@ConfigurationProperties(prefix = "wx")
@Configuration
@Data
public class WxProps {


    private String appId;

    private String appsecret;

}
