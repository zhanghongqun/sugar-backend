package com.sugar.infrastructure.params;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * Created by zhanghongqun on 2020/6/14.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuParams {

    private List<Button> button;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Button {
        private String type;
        private String name;
        private String key;
        private String url;
        private List<Button> sub_button;
    }
}
