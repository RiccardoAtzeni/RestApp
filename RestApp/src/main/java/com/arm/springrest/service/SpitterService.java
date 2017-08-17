package com.arm.springrest.service;

import com.arm.springrest.model.Spitter;

import javax.transaction.Transactional;

@Transactional
public interface SpitterService {

    public void createSpitter(Spitter s);
}
