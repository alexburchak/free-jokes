package org.translations.free.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.translations.free.dao.BaseDAO;
import org.translations.free.dao.UserDAO;
import org.translations.free.domain.User;
import org.translations.free.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<Long, User> implements UserService
{
    @Autowired
    private UserDAO userDAO;

    @Override
    protected BaseDAO<Long, User> getDAO()
    {
        return userDAO;
    }
}
