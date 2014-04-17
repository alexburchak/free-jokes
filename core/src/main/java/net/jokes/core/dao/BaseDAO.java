package net.jokes.core.dao;

import java.io.Serializable;

public interface BaseDAO<ID extends Serializable, T> {
    T findById(ID id);

    T save(T entity);

    T update(T entity);

    void remove(T entity);
}
