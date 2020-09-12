package com.sugar.infrastructure.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by zhanghongqun on 2020/8/25.
 */
@Data
@Builder
public class ProcessDto {
    private long id;
    private int step;
    private long taskId;
    /**
     * 当前任务的状态
     * */
    private int status;

}
