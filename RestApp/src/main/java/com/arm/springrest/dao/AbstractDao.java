package com.arm.springrest.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface AbstractDao <T, PK extends Serializable> {

    //returns list of objects from the T table
    List<T> findAll();

    //persist the newIstance object into db
    PK create(T newIstance);

    //Retrieve an object that was previously persisted to the db using the pk
    T find(PK id);

    //Save changes made to a persistent object
    void update(T transientObject);

    void delete(T peristentObject);

}
