package com.sugar.service;

import com.google.common.collect.Lists;
import com.sugar.domain.Customer;
import com.sugar.domain.Order;
import com.sugar.domain.Process;
import com.sugar.domain.Task;
import com.sugar.infrastructure.dto.ProcessDto;
import com.sugar.infrastructure.dto.TaskDto;
import com.sugar.infrastructure.enums.OrderStatus;
import com.sugar.infrastructure.enums.ProcessStatus;
import com.sugar.infrastructure.mapper.TaskMapper;
import com.sugar.infrastructure.params.CreateTaskParams;
import com.sugar.infrastructure.params.SubmitOrderParams;
import com.sugar.infrastructure.params.TaskFilterParams;
import com.sugar.repository.CustomerRepository;
import com.sugar.repository.task.OrderRepository;
import com.sugar.repository.task.ProcessRepository;
import com.sugar.repository.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhanghongqun on 2020/6/14.
 */
@Service
public class TaskService {

    final TaskRepository taskRepository;
    final ProcessRepository processRepository;
    final CustomerRepository customerRepository;
    final OrderRepository orderRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, ProcessRepository processRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.taskRepository = taskRepository;
        this.processRepository = processRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    public List<TaskDto> getAuditOrCanReceive(Long customer) {
        List<Process> processes = processRepository.getByCustomerAndStatuses(customer, Lists.newArrayList(ProcessStatus.AUDIT));
        if (!CollectionUtils.isEmpty(processes)) {
            TaskDto taskInAudit = TaskMapper.map(taskRepository.get(processes.get(0).getTaskId()));
            taskInAudit.setProcessStatus(ProcessStatus.AUDIT.getCode());
            return Lists.newArrayList(taskInAudit);
        }
        return taskRepository.getCustomerCanReceive(customer).stream().map(TaskMapper::map).collect(Collectors.toList());
    }

    public List<TaskDto> getList(TaskFilterParams params) {
        return taskRepository.getList(params).stream().map(TaskMapper::map).collect(Collectors.toList());
    }

    public TaskDto getById(Long id) {
        return TaskMapper.map(taskRepository.get(id));
    }

    /**
     * 后台创建任务
     */
    @Transactional
    public Long create(CreateTaskParams params) {
        return taskRepository.save(TaskMapper.map(params));
    }

    /**
     * 客户接受任务
     */
    @Transactional
    public ProcessDto receive(Long customerId, Long taskId) {
        checkCondition(customerId, taskId);
        Process process = Process.createCustomerReceiveTask(customerId, taskId);
        processRepository.save(process);
        return ProcessDto.builder().step(process.getStep()).taskId(taskId).id(process.getId()).build();
    }

    /**
     * 提交任务进度
     */
    @Transactional
    public void submitProcess(SubmitOrderParams processParams) {
        Process process = getDoing(processParams.getCustomerId());
        if (processParams.getIdentifierPics() != null) {
            process.fillIdentity(processParams.getIdentifierPics(), processParams.getWangWangNo());
        }
        if (processParams.getOrderNo() != null) {
            process.fillOrderNo(processParams.getOrderNo());
        }
        if (processParams.getOrderPic() != null) {
            process.fillOrderPic(processParams.getOrderPic());


        }
        processRepository.save(process);
    }

    /**
     * 审核任务是否完成有效
     */
    @Transactional
    public void auditProcess(Long processId, ProcessStatus processStatus) {
        Process process = processRepository.get(processId);
        if (process.getStatus().getCode() == ProcessStatus.PASS.getCode() || process.getStatus().getCode() == ProcessStatus.FAIL.getCode()) {
            throw new UnsupportedOperationException("重复确认");
        }
        process.setStatus(processStatus);
        createOrder(process);
        if (processStatus.getCode() == ProcessStatus.PASS.getCode()) {
           /*
           * 奖励
           * **/
        }
        processRepository.save(process);
    }


    private void createOrder(Process process) {
        Order order = new Order();
        Task task = taskRepository.get(process.getTaskId());
        order.setReward(task.getReward());
        order.setProcessId(process.getId());
        order.setStatus(process.getStatus().getCode() == ProcessStatus.PASS.getCode() ? OrderStatus.COMPLETE : OrderStatus.FAIL);
        order.setCustomerId(process.getCustomerId());
        order.setCreate(new Date());
        orderRepository.save(order);
    }

    /**
     * 放弃任务
     */
    public void abandon(Long customerId, Long processId) {
        Process process = processRepository.get(processId);
        process.abandon();
        processRepository.save(process);
    }

    public Process getDoing(Long customerId) {
        List<Process> processes = processRepository.getByCustomerAndStatuses(customerId, Lists.newArrayList(
                ProcessStatus.AUDIT,
                ProcessStatus.RECEIVE,
                ProcessStatus.DOING));
        if (processes.size() > 0) {
            return processes.get(0);
        }
        return null;
    }

    /**
     * 用户接任务条件验证
     * 1. 账户是否可信任
     * 2.
     */
    public void checkCondition(Long customerId, Long taskId) {
        Customer customer = customerRepository.get(customerId);
        Task task = taskRepository.get(taskId);
    }

    /**
     * 验证订单信息
     * TODO
     * 微信号 淘宝号一致 erp对接
     */
    public void checkOrder() {

    }

    /**
     * 任务创建审核
     */
    public void audit(Long taskId) {
        Task task = taskRepository.get(taskId);
        task.pass();
        taskRepository.save(task);
    }

}
