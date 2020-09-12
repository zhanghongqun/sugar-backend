package com.sugar.infrastructure.task;

import com.sugar.infrastructure.WxProps;
import com.sugar.infrastructure.cache.TokenCache;
import com.sugar.infrastructure.client.WXClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanghongqun on 2020/6/14.
 */
@EnableScheduling
@Component
public class TokenTask {
    final WXClient wxClient;
    final WxProps wxProps;

    public TokenTask(WXClient wxClient, WxProps wxProps) {
        this.wxClient = wxClient;
        this.wxProps = wxProps;
    }

    @Scheduled(fixedRate = 5000000 )
    public void updateToken() {
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "client_credential");
        params.put("appid", wxProps.getAppId());
        params.put("secret", wxProps.getAppsecret());
        Map<String, Object> result = wxClient.getToken(params);
        TokenCache.getInstance().updateToken((String) result.get("access_token"));
    }

}
