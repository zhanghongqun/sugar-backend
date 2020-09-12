package com.sugar.infrastructure.enums;

/**
 * Created by zhanghongqun on 2020/6/30.
 */
public enum OrderStatus {

    AUDIT(10, "审核中"), COMPLETE(20, "完成"), FAIL(30, "失败");

    String message;
    int code;

    OrderStatus(int code, String msg) {
        this.message = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static OrderStatus getByCode(int value) {
        if (value == 10) return AUDIT;
        if (value == 20) return COMPLETE;
        if (value == 30) return FAIL;
        throw new IllegalArgumentException("无效参数");
    }
}
