package com.sugar.repository.model;

import com.alibaba.fastjson.JSON;
import com.sugar.domain.Entity;
import com.sugar.domain.Task;
import com.sugar.domain.type.Condition;
import com.sugar.infrastructure.dto.TaskDto;
import com.sugar.infrastructure.enums.OrderStatus;
import com.sugar.infrastructure.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by zhanghongqun on 2020/6/14.
 */
@javax.persistence.Entity
@Table(name = "sugar.task")
@Data
public class TaskDo extends Entity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String description;
    /**
     * 任务列表图片
     */
    private String productPic;

    private String orderPic;

    /**
     * 条件json
     */
    private String conditions;

    private String introducePic;
    /**
     * 商场搜索关键字
     */
    private String searchKeyword;


    private String reward;

    private int status;
    private Date start;
    private Date end;

    public static TaskDo map(Task task) {
        TaskDo taskDo = new TaskDo();
        taskDo.setId(task.getId());
        taskDo.setName(task.getName());
        taskDo.setDescription(task.getDescription());
        taskDo.setProductPic(task.getProductPic());
        taskDo.setOrderPic(task.getOrderPic());
        taskDo.setSearchKeyword(task.getSearchKeyword());
        taskDo.setReward(task.getReward());
        taskDo.setIntroducePic(task.getIntroducePic());
        taskDo.setStatus(task.getStatus().getCode());
        taskDo.setConditions(JSON.toJSONString(task.getConditions()));
        taskDo.setStart(task.getStart());
        taskDo.setEnd(task.getEnd());
        return taskDo;
    }

    public Task map() {
        Task task = new Task();
        task.setId(id);
        task.setDescription(description);
        task.setStatus(TaskStatus.getByCode(status));
        task.setName(name);
        task.setIntroducePic(introducePic);
        task.setProductPic(productPic);
        task.setOrderPic(orderPic);
        task.setConditions(JSON.parseArray(conditions, Condition.class));
        task.setSearchKeyword(searchKeyword);
        task.setReward(reward);
        task.setStart(start);
        task.setEnd(end);
        return task;
    }
}
