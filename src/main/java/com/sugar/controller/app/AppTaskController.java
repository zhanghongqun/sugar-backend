package com.sugar.controller.app;

import com.sugar.infrastructure.dto.TaskDto;
import com.sugar.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhanghongqun on 2020/6/28.
 */
@RequestMapping("app")
@RestController
public class AppTaskController {

    final TaskService taskService;


    @Autowired
    public AppTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("tasks/{id}")
    public TaskDto get(@PathVariable Long id) {
        return taskService.getById(id);
    }

    @GetMapping("tasks")
    public List<TaskDto> getAuditOrCanReceive(@RequestParam Long customerId) {
        List<TaskDto> tasks = taskService.getAuditOrCanReceive(customerId);

        return tasks;
    }


}
