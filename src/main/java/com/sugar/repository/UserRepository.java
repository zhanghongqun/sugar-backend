package com.sugar.repository;

import com.sugar.domain.User;
import com.sugar.repository.model.UserDo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by zhanghongqun on 2020/6/21.
 */
@Repository
public class UserRepository extends BaseJpaRepository<UserDo, Long> {
    public UserRepository(EntityManager em) {
        super(UserDo.class, em);
    }

    public User findByName(String name) {
        Query query = em.createNativeQuery("select * from sugar_user where username=:name", UserDo.class);
        query.setParameter("name", name);

        UserDo user = (UserDo) query.getSingleResult();
        return user.map();
    }
}
