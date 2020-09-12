package com.sugar.infrastructure.mapper;

import com.sugar.domain.Process;
import com.sugar.infrastructure.dto.ProcessDto;

/**
 * Created by zhanghongqun on 2020/8/25.
 */
public class ProcessMapper {

    public static ProcessDto map(Process process) {
        if (process == null) return null;
        return ProcessDto.builder()
                .id(process.getId())
                .taskId(process.getTaskId())
                .step(process.getStep())
                .status(process.getStatus().getCode())
                .build();
    }
}
