package com.sugar.infrastructure.params;

import lombok.Data;

import java.util.List;

/**
 * Created by zhanghongqun on 2020/8/23.
 */
@Data
public class SubmitOrderParams {
    private Long customerId;
    private String orderNo;
    private Long processId;
    private String wangWangNo;
    /**
     * 身份验证
     * */
    private List<String> identifierPics;


    private String orderPic;
}
