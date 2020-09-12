package com.sugar.controller.task;

import com.sugar.infrastructure.dto.TaskDto;
import com.sugar.infrastructure.params.CreateTaskParams;
import com.sugar.infrastructure.params.TaskFilterParams;
import com.sugar.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by zhanghongqun on 2020/6/21.
 */
@RequestMapping("task")
@RestController
public class TaskController {

    final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Long create(@RequestBody CreateTaskParams params) {
        return taskService.create(params);
    }


    @GetMapping({"{id}"})
    public TaskDto getOne(@PathVariable Long id) {
        TaskDto taskDto= taskService.getById(id);
        taskDto.setStart(new Date());
        return taskDto;
    }

    @GetMapping("list")
    public List<TaskDto> getList( TaskFilterParams param) {
        return taskService.getList(param);
    }





}
