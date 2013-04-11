package net.jokes.core.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<ID extends Serializable, T> {
    T findById(ID id);

    T save(T entity);

    void remove(T entity);

    List<T> findAll();
}
