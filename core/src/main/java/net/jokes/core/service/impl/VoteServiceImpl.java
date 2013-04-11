package net.jokes.core.service.impl;

import net.jokes.core.dao.BaseDAO;
import net.jokes.core.dao.VoteDAO;
import net.jokes.core.domain.Vote;
import net.jokes.core.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl extends BaseServiceImpl<Long, Vote> implements VoteService {
    @Autowired
    private VoteDAO voteDAO;

    @Override
    protected BaseDAO<Long, Vote> getDAO() {
        return voteDAO;
    }
}
