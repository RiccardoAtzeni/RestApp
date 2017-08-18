package com.arm.springrest.service;

import com.arm.springrest.model.Spitter;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SpitterService {

    public void createSpitter(Spitter s);
    Spitter findByUsername(String username);
}
