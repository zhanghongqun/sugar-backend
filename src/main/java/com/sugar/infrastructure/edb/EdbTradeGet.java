package com.sugar.infrastructure.edb;

import lombok.Data;

/**
 * Created by zhanghongqun on 2020/7/13.
 */
@Data
public class EdbTradeGet extends Invocation {

    private String data_type;
    private String begin_time;
    private String end_time;
    private String shopid;
    private String out_tid;

}
