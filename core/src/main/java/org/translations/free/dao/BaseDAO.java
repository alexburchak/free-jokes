package org.translations.free.dao;

import java.io.Serializable;

public interface BaseDAO<ID extends Serializable, T> {
    T findById(ID id);
}
