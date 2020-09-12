package com.sugar.infrastructure.enums;

/**
 * Created by zhanghongqun on 2020/6/30.
 */
public enum RefundStatus {

    COMPLETE(10, "审核中"), UN(20, "放弃");

    String message;
    int code;

    RefundStatus(int code, String msg) {
        this.message = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static RefundStatus getByCode(int value) {
        if (value == 10) return COMPLETE;
        if (value == 20) return UN;
        throw new IllegalArgumentException("无效参数");
    }
}
