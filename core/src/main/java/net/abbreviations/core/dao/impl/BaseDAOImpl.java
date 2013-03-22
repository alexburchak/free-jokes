package net.abbreviations.core.dao.impl;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.abbreviations.core.dao.BaseDAO;

public abstract class BaseDAOImpl<ID extends Serializable, T> implements BaseDAO<ID, T> {
    @PersistenceContext(name = "persistenceUnit")
    private EntityManager entityManager;

    private Class<T> targetClass;

    protected BaseDAOImpl(Class<T> targetClass)
    {
        this.targetClass = targetClass;
    }

    public T findById(ID id)
    {
        return entityManager.find(targetClass, id);
    }

    public T save(T entity)
    {
        entityManager.persist(entity);
        return entity;
    }

    public void remove(T entity)
    {
        entityManager.remove(entity);
    }
}