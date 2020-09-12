package com.sugar.infrastructure.params;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * Created by zhanghongqun on 2020/6/21.
 */
@Data
public class CreateTaskParams {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    /**
     * 任务列表图片
     */
    @NotEmpty
    private String productPic;

    private String orderPic;

    private String introducePic;
    /**
     * 任务详情图片
     */
    //private List<String> detailsPic;

    /**
     * 商场搜索关键字
     */
    @NotEmpty
    private String searchKeyword;
    @NotEmpty
    private String reward;

    private Date start;
    private Date end;


}
