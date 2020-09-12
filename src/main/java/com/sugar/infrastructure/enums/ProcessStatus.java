package com.sugar.infrastructure.enums;

/**
 * Created by zhanghongqun on 2020/6/30.
 */
public enum ProcessStatus {

    RECEIVE(10, "准备"), AUDIT(20, "身份审核"), DOING(30, "进行中"), COMPLETE(40, "任务审核"), PASS(50, "奖励"), FAIL(60, "失败"), ABANDON(70, "放弃");

    String message;
    int code;

    ProcessStatus(int code, String msg) {
        this.message = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ProcessStatus getByCode(int value) {
        if (value == 10) return RECEIVE;
        if (value == 20) return AUDIT;
        if (value == 30) return DOING;
        if (value == 40) return COMPLETE;
        if (value == 50) return PASS;
        if (value == 60) return FAIL;
        if (value == 70) return ABANDON;

        throw new IllegalArgumentException("无效参数");
    }
}
