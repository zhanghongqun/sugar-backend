package com.sugar.infrastructure.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhanghongqun on 2020/5/19.
 */
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    // This is invoked when user tries to access a secured REST resource without the necessary authorization
    // We should just send a 403 Forbidden response because there is no 'error' page to redirect to
    // Here you can place any message you want
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
    }
}
