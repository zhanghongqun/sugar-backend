package com.sugar.repository.task;

import com.sugar.domain.Process;
import com.sugar.infrastructure.enums.ProcessStatus;
import com.sugar.repository.BaseJpaRepository;
import com.sugar.repository.model.ProcessDo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zhanghongqun on 2020/6/30.
 */
@Repository
public class ProcessRepository extends BaseJpaRepository<ProcessDo, Long> {
    public ProcessRepository(EntityManager em) {
        super(ProcessDo.class, em);
    }


    public List<Process> getByCustomerAndStatuses(Long customerId, List<ProcessStatus> status) {
        Query query = em.createNativeQuery("select * from sugar_process WHERE status in(:status) and customer_id=:customerId", ProcessDo.class);
        query.setParameter("customerId", customerId);
        query.setParameter("status", status.stream().map(s->s.getCode()).collect(toList()));
        List<ProcessDo> result = query.getResultList();
        return result.stream().map(p -> p.map()).collect(toList());
    }

    public Process get(Long processId) {
        ProcessDo process = super.getOne(processId);
        return process.map();
    }


    public Long save(Process process) {
        ProcessDo processDo = ProcessDo.map(process);
        super.save(processDo);
        process.setId(processDo.getId());
        return processDo.getId();
        /**
         * TODO 其他关联对象保存
         * */
    }


    public List<Process> getBySpec(ProcessStatus status,String keyword) {
        Query query = em.createNativeQuery("select * from sugar_process WHERE status=:status", ProcessDo.class);
        query.setParameter("status", status.getCode());
        List<ProcessDo> result = query.getResultList();
        return result.stream().map(p -> p.map()).collect(toList());
    }

}
