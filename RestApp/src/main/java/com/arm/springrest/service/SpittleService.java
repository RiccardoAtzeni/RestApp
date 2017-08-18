package com.arm.springrest.service;

import com.arm.springrest.model.Spittle;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SpittleService {

    public List<Spittle> findLatest(int maxperiod);
}
