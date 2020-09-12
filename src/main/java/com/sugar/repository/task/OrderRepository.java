package com.sugar.repository.task;

import com.sugar.domain.Order;
import com.sugar.infrastructure.dto.OrderDto;
import com.sugar.repository.BaseJpaRepository;
import com.sugar.repository.model.OrderDo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zhanghongqun on 2020/8/23.
 */
@Repository
public class OrderRepository extends BaseJpaRepository<OrderDo, Long> {


    public OrderRepository(EntityManager em) {
        super(OrderDo.class, em);
    }


    public Long save(Order order) {
        OrderDo result = super.save(OrderDo.map(order));
        return result.getId();
    }

    public List<OrderDto> getByCustomer(Long customerId, Integer page) {
        Query query = em.createNativeQuery("select * from sugar_order WHERE customer_id=:customerId", OrderDo.class);
        query.setParameter("customerId", customerId);
        List<OrderDo> result = query.getResultList();
        return result.stream().map(o -> o.mapTo()).collect(toList());
    }

    public Order get(Long id){
        OrderDo order = super.getOne(id);
        return order.map();
    }
}



