package com.sugar.infrastructure.exception;

/**
 * Created by zhanghongqun on 2020/7/13.
 */
public class ServiceException extends RuntimeException {


    private ServiceException(String msg) {
        super(msg);
    }
}
