package com.sugar.repository.task;

import com.sugar.domain.Task;
import com.sugar.domain.User;
import com.sugar.infrastructure.dto.TaskDto;
import com.sugar.infrastructure.params.TaskFilterParams;
import com.sugar.repository.BaseJpaRepository;
import com.sugar.repository.model.TaskDo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhanghongqun on 2020/6/21.
 */
@Repository
public class TaskRepository extends BaseJpaRepository<TaskDo, Long> {

    public TaskRepository(EntityManager em) {
        super(TaskDo.class, em);
    }

    public Task get(Long id) {
        TaskDo taskDo = super.getOne(id);
        return taskDo.map();
    }

    public List<Task> getCustomerCanReceive(Long customerId) {
        Query query = em.createNativeQuery("select * from sugar_task  where id not in (select task_id FROM  sugar_process  WHERE customer_id=:customerId)", TaskDo.class);
        query.setParameter("customerId", customerId);
        List<TaskDo> result = query.getResultList();
        return result.stream().map(t -> t.map()).collect(Collectors.toList());
    }

    public List<Task> getList(TaskFilterParams params) {
        StringBuilder sql = new StringBuilder("select * from sugar_task where 1=1 ");
        if (StringUtils.isNotEmpty(params.name)) {
            sql.append("and name=:name");
        }
        Query query = em.createNativeQuery(sql.toString(), TaskDo.class);
        if (StringUtils.isNotEmpty(params.name)) {
            query.setParameter("name", params.name);
        }
        List<TaskDo> result = query.getResultList();
        return result.stream().map(t -> t.map()).collect(Collectors.toList());
    }

    public Long save(Task task) {
        super.save(TaskDo.map(task));
        return task.getId();
    }
}
