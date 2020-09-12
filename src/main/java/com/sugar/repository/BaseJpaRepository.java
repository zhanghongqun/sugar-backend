package com.sugar.repository;


import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

/**
 * Created by zhanghongqun on 2020/5/25.
 */

public abstract class BaseJpaRepository<T, ID> extends SimpleJpaRepository<T, ID> {


//    protected final QuerydslJpaPredicateExecutor<T> jpaPredicateExecutor;
    protected final EntityManager em;

    public BaseJpaRepository(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
//        this.jpaPredicateExecutor = new QuerydslJpaPredicateExecutor<>(JpaEntityInformationSupport.getEntityInformation(domainClass, em), em, SimpleEntityPathResolver.INSTANCE, getRepositoryMethodMetadata());
    }
}
