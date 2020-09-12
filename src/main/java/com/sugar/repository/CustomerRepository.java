package com.sugar.repository;

import com.sugar.domain.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by zhanghongqun on 2020/6/29.
 */
@Repository
public class CustomerRepository extends BaseJpaRepository<Customer, Long> {
    public CustomerRepository(EntityManager em) {
        super(Customer.class, em);
    }

    public Customer getByOpenId(String openid) {
        Query query = em.createNativeQuery("select * from sugar_customer where openid=:openid", Customer.class);
        query.setParameter("openid", openid);
        List list = query.getResultList();
        if (list.size() > 0) return (Customer) list.get(0);
        return null;
    }

    public Customer get(Long id) {
        return super.getOne(id);
    }
}