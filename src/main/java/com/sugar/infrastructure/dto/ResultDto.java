package com.sugar.infrastructure.dto;

import lombok.Data;

/**
 * Created by zhanghongqun on 2020/6/21.
 */
@Data
public class ResultDto {
    private Object data;

    public ResultDto() {

    }

    public ResultDto(Object data) {
        this.data = data;
    }
}
