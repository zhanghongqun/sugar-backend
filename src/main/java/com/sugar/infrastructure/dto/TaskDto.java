package com.sugar.infrastructure.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Created by zhanghongqun on 2020/6/21.
 */
@Data
@Builder
public class TaskDto {
    private Long id;
    private String name;

    private String description;
    /**
     * 任务列表图片
     */
    private String productPic;

    private String orderPic;
    private String introducePic;
    /**
     * 商场搜索关键字
     */
    private String searchKeyword;

    private String reward;
    private String status;

    private Date start;
    private Date end;

    /**
     * 进行中任务的状态
     * */
    private int processStatus;


}
