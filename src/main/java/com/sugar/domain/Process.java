package com.sugar.domain;

import com.sugar.infrastructure.enums.ProcessStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 接任务
 * 提交基本信息
 * 提交订单号，截图
 * 后台系统验收 更新订单状态
 * 根据订单状态付款，
 */
@Data
public class Process extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;

    private Long taskId;

    private List<String> identifiers;
    /**
     *
     * */
    private String orderNo;

    private String orderPic;

    private String wangWangNo;
    /**
     * 任务进度  身份审核中 。。
     */
    private ProcessStatus status;

    /**
     * 当前任务进度
     */
    private int step;

    public void fillIdentity(List<String> identifiers, String wangWangNo) {
        this.identifiers = identifiers;
        this.wangWangNo = wangWangNo;
        step = 1;
        status = ProcessStatus.AUDIT;
    }

    public void fillOrderNo(String no) {
        this.orderNo = no;
        step = 2;
    }

    public void fillOrderPic(String pic) {
        this.orderPic = pic;
        step = 3;
        status = ProcessStatus.COMPLETE;
    }

    public void abandon() {
        this.status = ProcessStatus.ABANDON;
    }

    public static Process createCustomerReceiveTask(Long customerId, Long taskId) {
        Process process = new Process();
        process.customerId = customerId;
        process.taskId = taskId;
        process.status = ProcessStatus.RECEIVE;
        return process;
    }

}
