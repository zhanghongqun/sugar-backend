package com.sugar.controller.app;

import com.sugar.infrastructure.oss.OssClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by zhanghongqun on 2020/8/23.
 */
@RequestMapping("app/file")
@RestController
public class AppFileController {

    @PostMapping
    public String upload(MultipartFile file) throws IOException {

        String fileName = UUID.randomUUID().toString().replaceAll("-", "");
        return OssClient.upload("process/" + fileName, file.getBytes());

    }

}
