package net.abbreviations.core.service.impl;

import net.abbreviations.core.dao.BaseDAO;
import net.abbreviations.core.dao.UserDAO;
import net.abbreviations.core.domain.User;
import net.abbreviations.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<Long, User> implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    protected BaseDAO<Long, User> getDAO() {
        return userDAO;
    }
}
