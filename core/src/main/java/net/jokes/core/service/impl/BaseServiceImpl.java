package net.jokes.core.service.impl;

import net.jokes.core.dao.BaseDAO;
import net.jokes.core.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<ID extends Serializable, T> implements BaseService<ID, T> {
    protected abstract BaseDAO<ID, T> getDAO();

    @Transactional(readOnly = true)
    public T findById(ID id) {
        return getDAO().findById(id);
    }

    @Transactional
    public T save(T entity) {
        return getDAO().save(entity);
    }

    @Transactional
    public void remove(T entity) {
        getDAO().remove(entity);
    }

    @Override
    public List<T> findAll() {
        return getDAO().findAll();
    }
}
