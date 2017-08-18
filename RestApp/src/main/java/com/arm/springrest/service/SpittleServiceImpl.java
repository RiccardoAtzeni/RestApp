package com.arm.springrest.service;

import com.arm.springrest.dao.SpittleDao;
import com.arm.springrest.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("spittleService")
public class SpittleServiceImpl implements SpittleService {

    @Autowired
    SpittleDao spittleDao;

    @Override
    public List<Spittle> findLatest(int maxperiod) {
        return spittleDao.findLatest(maxperiod);
    }
}
