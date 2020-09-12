package com.sugar.infrastructure.enums;

/**
 * Created by zhanghongqun on 2020/8/23.
 */
public enum OrderSource {

    TM(10, "天猫");
    String message;
    int code;

    OrderSource(int code, String msg) {
        this.message = msg;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public static OrderSource getByCode(int value) {
        if (value == 10) return TM;

        throw new IllegalArgumentException("无效参数");
    }
}
