package net.jokes.core.service.impl;

import net.jokes.core.dao.BaseDAO;
import net.jokes.core.dao.JokeViewDAO;
import net.jokes.core.service.JokeViewService;
import net.jokes.core.view.JokeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JokeViewServiceImpl extends BaseServiceImpl<String, JokeView> implements JokeViewService {
    @Autowired
    private JokeViewDAO voteDAO;

    @Override
    protected BaseDAO<String, JokeView> getDAO() {
        return voteDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<JokeView> getTopJokes(int count) {
        return voteDAO.getTopJokes(count);
    }
}
