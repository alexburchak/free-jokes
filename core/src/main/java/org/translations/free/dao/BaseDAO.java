package org.translations.free.dao;

import java.io.Serializable;

public interface BaseDAO<ID extends Serializable, T> {
    T findById(ID id);

    T save(T entity);

    void remove(T entity);
}
