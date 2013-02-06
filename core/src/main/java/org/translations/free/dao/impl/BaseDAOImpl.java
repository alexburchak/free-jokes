package org.translations.free.dao.impl;

import java.io.Serializable;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.translations.free.dao.BaseDAO;

public abstract class BaseDAOImpl<ID extends Serializable, T> implements BaseDAO<ID, T> {
    private Session session;
    private Class<T> targetClass;

    protected BaseDAOImpl(Class<T> targetClass)
    {
        this.targetClass = targetClass;
    }

    @Autowired
    public void setSession(Session session)
    {
        this.session = session;
    }

    @SuppressWarnings("unchecked")
    public T findById(ID id)
    {
        return (T)session.get(targetClass, id);
    }
}
