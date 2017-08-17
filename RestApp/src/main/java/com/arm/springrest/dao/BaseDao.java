package com.arm.springrest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public abstract class BaseDao<T,PK extends Serializable> implements AbstractDao<T, PK>{

    private Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    public BaseDao(){
        ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
        persistentClass = (Class) pt.getActualTypeArguments()[0];
    }

    public BaseDao(Class<T> persistentClass){
        this.persistentClass=persistentClass;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){   return sessionFactory.getCurrentSession();  }

    @Override
    public List findAll() {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PK create(T newIstance) {
        return (PK) getSession().save(newIstance);
    }

    @Override
    public T find(PK id) {
        return (T) getSession().get(persistentClass,id);
    }

    @Override
    public void update(T object) {
        getSession().update(object);
    }

    @Override
    public void delete(T object) {
        getSession().delete(object);
    }
}
