package net.abbreviations.core.dao.impl;

import net.abbreviations.core.dao.UserDAO;
import org.springframework.stereotype.Repository;
import net.abbreviations.core.domain.User;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<Long, User> implements UserDAO {
    protected UserDAOImpl()
    {
        super(User.class);
    }
}
