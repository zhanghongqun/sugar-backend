package com.sugar.domain.type;

import lombok.Builder;
import lombok.Data;

/**
 * Created by zhanghongqun on 2020/8/23.
 */
@Data
@Builder
public class Condition {
    private Long taskId;
    private String key;
    private String value;
}
