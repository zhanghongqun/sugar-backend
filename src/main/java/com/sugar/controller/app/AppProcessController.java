package com.sugar.controller.app;

import com.sugar.infrastructure.dto.ProcessDto;
import com.sugar.infrastructure.params.SubmitOrderParams;
import com.sugar.service.TaskService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhanghongqun on 2020/8/25.
 */
@RequestMapping("app")
@RestController
public class AppProcessController {

    final TaskService taskService;

    @Autowired
    public AppProcessController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("process")
    public ProcessDto receive(@RequestBody ReceiveParams receiveParams) {
        return taskService.receive(receiveParams.getCustomerId(), receiveParams.getTaskId());
    }

    @PutMapping("process/_abandon")
    public void abandon(@RequestBody AbandonParams abandonParams) {
        taskService.abandon(abandonParams.getCustomerId(), abandonParams.getProcessId());
    }


    @PutMapping("process/_submit")
    public void submitProcess(@RequestBody SubmitOrderParams submitOrderParams) {
        taskService.submitProcess(submitOrderParams);
    }

    @Data
    public static class ReceiveParams {
        private Long customerId;
        private Long taskId;
    }

    @Data
    public static class AbandonParams {
        private Long customerId;
        private Long processId;
    }
}
