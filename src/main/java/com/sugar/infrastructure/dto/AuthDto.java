package com.sugar.infrastructure.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by zhanghongqun on 2020/6/21.
 */
@Data
@Builder
public class AuthDto {

    private String token;
}
