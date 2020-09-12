package com.sugar.controller.app;

import com.sugar.service.WXService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

/**
 * Created by zhanghongqun on 2020/6/26.
 */
@RestController
@RequestMapping("app/notify")
@Slf4j
public class NotifyController {
    final
    WXService wxService;

    @Autowired
    public NotifyController(WXService wxService) {
        this.wxService = wxService;
    }

    @GetMapping
    public void notify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String code = request.getParameter("code");
        response.getWriter().write(request.getParameter("echostr"));

    }

    @PostMapping
    public String receive(HttpServletRequest request) throws Exception {
        String messageStr = StreamUtils.copyToString(request.getInputStream(), Charset.forName("utf-8"));

        return "receive";
    }
}

