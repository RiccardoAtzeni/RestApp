package com.arm.springrest.dao.impl;

import com.arm.springrest.dao.BaseDao;
import com.arm.springrest.dao.SpitterDao;
import com.arm.springrest.model.Spitter;
import com.arm.springrest.service.SpitterServiceImpl;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="spitterDao")
public class SpitterDaoImpl extends BaseDao<Spitter,Long> implements SpitterDao{

    private static Logger logger = LoggerFactory.getLogger(SpitterDaoImpl.class);

    @Override
    public List<Spitter> findByUsername(String username) {

        Query query = getSession().createQuery(
                "from com.arm.springrest.model.Spitter s "
                + "where s.username = :username");
        query.setParameter("username",username);

        List<Spitter> result = (List<Spitter>) query.getResultList();

        if(result!=null && !(result.isEmpty()))
            logger.info("Find a spitter with username: "+username);
        else
            logger.warn("No spitter with username: "+username+" found!");

        return result;

    }
}
