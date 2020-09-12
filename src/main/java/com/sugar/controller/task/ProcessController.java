package com.sugar.controller.task;

import com.sugar.domain.Process;
import com.sugar.infrastructure.dto.TaskDto;
import com.sugar.infrastructure.enums.ProcessStatus;
import com.sugar.infrastructure.params.ProcessFilterParams;
import com.sugar.repository.CustomerRepository;
import com.sugar.repository.task.ProcessRepository;
import com.sugar.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zhanghongqun on 2020/8/30.
 */
@RestController
@RequestMapping("process")
public class ProcessController {
    @Autowired
    ProcessRepository processRepository;
    @Autowired
    TaskService taskService;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public List<ProcessDto> getByStatus( ProcessFilterParams params) {
        return processRepository.getBySpec(ProcessStatus.getByCode(params.status),params.keyword).stream().map(process -> {
            ProcessDto dto = ProcessDto.map(process);
            dto.task = taskService.getById(process.getTaskId());
            dto.customer = customerRepository.get(process.getCustomerId()).getName();
            return dto;
        }).collect(toList());

    }

    @GetMapping("{id}")
    public ProcessDto get(@PathVariable Long id) {
        return ProcessDto.map(processRepository.get(id));
    }

    @PutMapping
    public void audit(@RequestBody AuditParam param) {
        taskService.auditProcess(param.processId, ProcessStatus.getByCode(param.status));
    }


    public static class AuditParam {
        public Long processId;
        public Integer status;
    }


    public static class ProcessDto {
        public Long id;
        public String customer;

        public TaskDto task;

        public List<String> identifiers;
        public String orderNo;

        public String orderPic;

        public Integer status;
        public  String wangWangNo;

        public static ProcessDto map(Process process) {
            ProcessDto dto = new ProcessDto();
            dto.id = process.getId();
            dto.identifiers = process.getIdentifiers();
            dto.orderNo = process.getOrderNo();
            dto.orderPic = process.getOrderPic();
            dto.status = process.getStatus().getCode();
            dto.wangWangNo=process.getWangWangNo();
            return dto;
        }
    }
}
