package com.sugar.infrastructure.security;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by zhanghongqun on 2020/5/20.
 */
public class UserNotActivatedException extends AuthenticationException {
    public UserNotActivatedException(String msg, Throwable t) {
        super(msg, t);
    }

    public UserNotActivatedException(String msg) {
        super(msg);
    }
}
