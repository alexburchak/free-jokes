package net.jokes.core.service.impl;

import net.jokes.core.dao.JokeDAO;
import net.jokes.core.dao.BaseDAO;
import net.jokes.core.domain.Joke;
import net.jokes.core.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JokeServiceImpl extends BaseServiceImpl<Long, Joke> implements JokeService {
    @Autowired
    private JokeDAO jokeDAO;

    @Override
    protected BaseDAO<Long, Joke> getDAO() {
        return jokeDAO;
    }
}
