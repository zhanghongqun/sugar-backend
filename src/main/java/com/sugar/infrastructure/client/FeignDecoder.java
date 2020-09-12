package com.sugar.infrastructure.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanghongqun on 2020/7/1.
 */
@Component
public class FeignDecoder implements Decoder {

    @Autowired
    private ObjectMapper mapper;

    /**
     * 这里统一处理，根据状态码判断返回正常还是异常的，
     * 200返回正常的，其他状态码直接抛出异常
     */
    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        if (response.status() >= 200 && response.status() <= 299) {
            String result = StreamUtils.copyToString(response.body().asInputStream(), Charset.forName("utf-8"));
            Map<String, Object> map = mapper.readValue(result, Map.class);
            return map;
        }
        return new HashMap<>();
    }
}