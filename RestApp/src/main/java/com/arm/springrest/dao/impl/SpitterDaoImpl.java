package com.arm.springrest.dao.impl;

import com.arm.springrest.dao.BaseDao;
import com.arm.springrest.dao.SpitterDao;
import com.arm.springrest.model.Spitter;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import java.util.List;

@Component("spitterDao")
public class SpitterDaoImpl extends BaseDao<Spitter,Long> implements SpitterDao{

    @Override
    public List<Spitter> findByUsername(String username) {

        Query query = getSession().createQuery(
                "from com.arm.springrest.model.Spitter s "
                + "where s.username = :username");
        query.setParameter("username",username);

        return query.getResultList();

    }
}
