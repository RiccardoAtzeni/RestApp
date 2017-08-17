package com.arm.springrest.service;

import com.arm.springrest.dao.SpitterDao;
import com.arm.springrest.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("spitterService")
public class SpitterServiceImpl implements SpitterService{
    @Autowired
    private SpitterDao spitterDao;

    @Override
    public void createSpitter(Spitter s) {
        spitterDao.create(s);
    }
}
