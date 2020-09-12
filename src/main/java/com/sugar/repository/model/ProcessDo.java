package com.sugar.repository.model;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sugar.domain.Process;
import com.sugar.infrastructure.enums.ProcessStatus;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;

/**
 * 接任务
 * 提交基本信息
 * 提交订单号，截图
 * 后台系统验收 更新订单状态
 * 根据订单状态付款，
 */
@Entity
@Table(name = "sugar.process")
@Data
public class ProcessDo extends com.sugar.domain.Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;

    private Long taskId;
    /**
     *
     * */
    private String orderNo;

    private String orderPic;

    private String identifiers;

    private String wangWangNo;
    private int status;

    private int step;

    public Process map() {
        Process process = new Process();
        process.setId(id);
        process.setCustomerId(customerId);
        process.setTaskId(taskId);
        process.setOrderNo(orderNo);
        process.setOrderPic(orderPic);
        process.setWangWangNo(wangWangNo);
        process.setStep(step);
        process.setStatus(ProcessStatus.getByCode(status));
        process.setIdentifiers(identifiers == null ? null : Lists.newArrayList(identifiers.split(",")));
        return process;
    }

    public static ProcessDo map(Process process) {
        ProcessDo processDo = new ProcessDo();
        processDo.setTaskId(process.getTaskId());
        processDo.setId(process.getId());
        processDo.setCustomerId(process.getCustomerId());
        processDo.setStep(process.getStep());
        processDo.setOrderNo(process.getOrderNo());
        processDo.setOrderPic(process.getOrderPic());
        processDo.setStatus(process.getStatus().getCode());
        processDo.setWangWangNo(process.getWangWangNo());
        processDo.setIdentifiers(process.getIdentifiers() == null ? null : StringUtils.join(process.getIdentifiers(), ","));
        return processDo;
    }

}
