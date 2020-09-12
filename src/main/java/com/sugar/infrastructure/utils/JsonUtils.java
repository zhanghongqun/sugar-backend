package com.sugar.infrastructure.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by zhanghongqun on 2020/6/14.
 */
@Slf4j
public class JsonUtils {


    public static String toString(Object value) {
        try {
            return new ObjectMapper().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return "";
    }
}
