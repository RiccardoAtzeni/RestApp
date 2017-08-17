package com.arm.springrest.dao;

import com.arm.springrest.model.Spitter;

import java.util.List;

public interface SpitterDao extends AbstractDao<Spitter,Long> {
    List<Spitter> findByUsername(String username);
}
