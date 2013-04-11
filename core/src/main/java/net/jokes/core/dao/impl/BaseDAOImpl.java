package net.jokes.core.dao.impl;

import net.jokes.core.dao.BaseDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

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

    public T findById(ID id) {
        return entityManager.find(targetClass, id);
    }

    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<T> findAll() {
        throw new UnsupportedOperationException();
    }
}
