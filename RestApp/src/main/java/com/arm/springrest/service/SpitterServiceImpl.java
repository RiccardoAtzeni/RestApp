package com.arm.springrest.service;

import com.arm.springrest.dao.SpitterDao;
import com.arm.springrest.dao.impl.SpittleDaoImpl;
import com.arm.springrest.model.Spitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("spitterService")
public class SpitterServiceImpl implements SpitterService{

    private static Logger logger = LoggerFactory.getLogger(SpitterServiceImpl.class);

    @Autowired
    private SpitterDao spitterDao;

    @Override
    public void createSpitter(Spitter s) {
        spitterDao.create(s);
    }

    @Override
    public Spitter findByUsername(String username){
        logger.info("Call the the findByUsername of "+getClass().getSimpleName());
        List<Spitter> spitterList = spitterDao.findByUsername(username);

        if(spitterList!=null && !(spitterList.isEmpty()))
        {
            if(spitterList.size()==1){
                return spitterList.get(0);
            }
            else{
                logger.warn("Multiple spitter found with username: "+username);
                return spitterList.get(0);
            }
        }
        else{
            logger.warn("No spitter found with username: "+username);
            return null;
        }

    }
}
