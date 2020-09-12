package com.sugar.infrastructure.enums;

/**
 * Created by zhanghongqun on 2020/6/30.
 */
public enum TaskStatus {

    DRAFT(10, "草稿"), PASS(20, "通过"), DOING(30, "进行中"), COMPLETE(40, "完成"), ABANDON(50, "放弃");

    String message;
    int code;

    TaskStatus(int code, String msg) {
        this.message = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static TaskStatus getByCode(int value) {
        if (value == 10) return DRAFT;
        if (value == 20) return PASS;
        if (value == 30) return DOING;
        if (value == 40) return COMPLETE;
        if (value == 50) return ABANDON;
        throw new IllegalArgumentException("无效参数");
    }
}
