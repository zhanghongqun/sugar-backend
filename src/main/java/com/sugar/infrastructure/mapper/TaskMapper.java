package com.sugar.infrastructure.mapper;

import com.sugar.domain.Task;
import com.sugar.infrastructure.dto.TaskDto;
import com.sugar.infrastructure.enums.TaskStatus;
import com.sugar.infrastructure.params.CreateTaskParams;

/**
 * Created by zhanghongqun on 2020/6/21.
 */
public class TaskMapper {

    public static Task map(CreateTaskParams params) {
        Task task = new Task();
        task.setDescription(params.getDescription());
        task.setName(params.getName());
        task.setIntroducePic(params.getIntroducePic());
        task.setProductPic(params.getProductPic());
        task.setOrderPic(params.getOrderPic());
        task.setReward(params.getReward());
        task.setSearchKeyword(params.getSearchKeyword());
        task.setStatus(TaskStatus.PASS);
        task.setStart(params.getStart());
        task.setEnd(params.getEnd());
        return task;
    }

    public static TaskDto map(Task task) {
        if (task == null) return null;
        return TaskDto.builder().description(task.getDescription())
                .id(task.getId())
                .name(task.getName())
                .productPic(task.getProductPic())
                .orderPic(task.getOrderPic())
                .introducePic(task.getIntroducePic())
                .reward(task.getReward())
                .searchKeyword(task.getSearchKeyword())
                .status(task.getStatus().getMessage())
                .start(task.getStart())
                .end(task.getEnd())
                .build();
    }
}
