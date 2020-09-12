package com.sugar.infrastructure.edb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sugar.infrastructure.utils.MD5;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by zhanghongqun on 2020/7/11.
 */
@Data
public class Invocation {
    private String dbhost = "edb_a86802";
    private String appkey = "852fd192";
    private String format = "json";
    private String method = "edbTradeGet";
    private String timestamp;
    private String v = "2.0";
    private String slencry = "0";
    private String Ip = "183.192.233.144";
    private String appSecret = "9166a6b612fa4407992369125ef5788f";
    private String token = "19b1096a0444470ca7d69cdcbb75ff01";
    private String sign;

    @JsonIgnore
    private Map<String, ?> requestMap;

    public Map<String, ?> getRequestMap() {
        if (requestMap != null) return requestMap;
        init();
        return requestMap;
    }

    private void init() {
        DateFormat format5 = new SimpleDateFormat("yyyyMMddhhmm");
        timestamp = format5.format(new Date());
        this.sign = sign();
        requestMap = toFormMap();
    }

    private Map<String, String> toSignMap() {
        TreeMap map = new ObjectMapper().convertValue(this, TreeMap.class);
        map.remove("sign");
        return map;
    }

    private String sign() {
        String paramStr = createLinkString(toSignMap());
        return MD5.sign(paramStr, "UTF-8").toUpperCase();
    }

    private Map<String, ?> toFormMap() {
        return new ObjectMapper().convertValue(this, TreeMap.class);
    }

    private String createLinkString(Map<String, ?> params) {
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        StringBuilder prestr = new StringBuilder();
        for (String key : keys) {
            String value = String.valueOf(params.get(key));
            if ("null".equals(value)) {
                continue;
            }
            prestr.append(key).append(value);
        }
        return "852fd192" + prestr.toString();
    }
}
