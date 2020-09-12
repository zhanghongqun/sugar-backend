package com.sugar.domain;

import com.sugar.domain.type.Condition;
import com.sugar.infrastructure.enums.TaskStatus;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * 创建任务，任务关联条件
 */
@Data
public class Task extends Entity {

    private Long id;
    private String name;

    private Long productId;
    private String description;
    private String productPic;

    private String orderPic;
    private String introducePic;
    /**
     * 任务详情图片
     */
    //private List<String> detailsPic;
    /**
     * 条件
     */
    private List<Condition> conditions;
    /**
     * 商场搜索关键字
     */
    private String searchKeyword;

    private String reward;

    private TaskStatus status;

    private Date start;
    private Date end;

    public void pass() {
        status = TaskStatus.PASS;
    }
}
