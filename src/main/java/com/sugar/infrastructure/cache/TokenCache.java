package com.sugar.infrastructure.cache;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by zhanghongqun on 2020/6/14.
 */
@Slf4j
public class TokenCache {

    private TokenCache() {
    }

    private String token;

    private static TokenCache instance;

    public static TokenCache getInstance() {
        if (instance == null) {
            instance = new TokenCache();
        }
        return instance;
    }

    public void updateToken(String token) {
        log.info("update toke :" + token);
        this.token = token;
    }

    public String getValue() {
        return token;
    }
}
