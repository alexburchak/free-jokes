package org.translations.free.service;

import java.io.Serializable;

public interface BaseService<ID extends Serializable, T> {
    T findById(ID id);

    T save(T entity);

    void remove(T entity);
}
