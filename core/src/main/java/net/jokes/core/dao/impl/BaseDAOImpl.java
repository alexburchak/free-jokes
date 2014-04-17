package net.jokes.core.dao.impl;

import net.jokes.core.dao.BaseDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public abstract class BaseDAOImpl<ID extends Serializable, T> implements BaseDAO<ID, T> {
    @PersistenceContext(name = "persistenceUnit")
    private EntityManager entityManager;

    private Class<T> targetClass;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected BaseDAOImpl(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public T findById(ID id) {
        return entityManager.find(targetClass, id);
    }

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void remove(T entity) {
        entityManager.remove(entity);
    }
}
