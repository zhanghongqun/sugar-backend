package com.sugar.controller.task;

import com.sugar.infrastructure.oss.OssClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by zhanghongqun on 2020/6/21.
 */
@RestController
@RequestMapping("file")
public class FileController {


    @PostMapping
    public String upload(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString().replaceAll("-", "");
        return OssClient.upload("process/" + fileName, file.getBytes());
    }

}
