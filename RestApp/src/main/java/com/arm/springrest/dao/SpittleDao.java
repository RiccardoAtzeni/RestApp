package com.arm.springrest.dao;

import com.arm.springrest.model.Spittle;

import java.util.List;

public interface SpittleDao extends AbstractDao<Spittle,Long> {
    List<Spittle> findLatest(int maxperiod);
}
