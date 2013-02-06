package org.translations.free.dao.impl;

import org.springframework.stereotype.Repository;
import org.translations.free.dao.UserDAO;
import org.translations.free.domain.User;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<Long, User> implements UserDAO {
    protected UserDAOImpl()
    {
        super(User.class);
    }
}
