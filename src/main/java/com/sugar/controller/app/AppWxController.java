package com.sugar.controller.app;

import com.sugar.infrastructure.dto.WxJsConfigDto;
import com.sugar.service.TaskService;
import com.sugar.service.WXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by zhanghongqun on 2020/7/8.
 */
@RequestMapping("app/wx")
@RestController
public class AppWxController {

    final WXService wxService;

    public AppWxController(WXService wxService) {
        this.wxService = wxService;
    }

    @PostMapping("sign")
    public WxJsConfigDto jsConfig(@RequestBody Map<String, Object> params) {
        return wxService.signJsConfig(params.get("url").toString());
    }


}
