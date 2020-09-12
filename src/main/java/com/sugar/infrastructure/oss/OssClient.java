package com.sugar.infrastructure.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;

/**
 * Created by zhanghongqun on 2020/8/24.
 */
public class OssClient {

    public static final String endpoint = "https://sugar3.oss-cn-beijing.aliyuncs.com/";

    static OSS ossClient = new OSSClientBuilder().build("oss-cn-beijing.aliyuncs.com", "LTAI4G68smzHZtTFqMSbUev7", "6OmRd2iAYduHor6ivuhLvzPWGt7yoa");

    /**
     * 返回完整的oss地址直接访问
     * */
    public static String upload(String fileName, byte[] bytes) {
        PutObjectResult result = ossClient.putObject("sugar3", fileName, new ByteArrayInputStream(bytes));
        return endpoint + fileName;
    }
}
