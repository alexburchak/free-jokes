package net.jokes.core.dao.impl;

import net.jokes.core.dao.VoteDAO;
import net.jokes.core.domain.Vote;
import org.springframework.stereotype.Repository;

@Repository("voteDAO")
public class VoteDAOImpl extends BaseDAOImpl<Long, Vote> implements VoteDAO {
    protected VoteDAOImpl() {
        super(Vote.class);
    }
}
