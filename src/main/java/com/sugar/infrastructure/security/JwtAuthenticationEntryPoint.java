package com.sugar.infrastructure.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhanghongqun on 2020/5/19.
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    // This is invoked when user tries to access a secured REST resource without supplying any credentials
    // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
    // Here you can place any message you want
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
    }
}
