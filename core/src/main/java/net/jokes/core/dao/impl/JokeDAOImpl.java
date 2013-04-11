package net.jokes.core.dao.impl;

import net.jokes.core.dao.JokeDAO;
import net.jokes.core.domain.Joke;
import org.springframework.stereotype.Repository;

@Repository("jokeDAO")
public class JokeDAOImpl extends BaseDAOImpl<Long, Joke> implements JokeDAO {
    protected JokeDAOImpl() {
        super(Joke.class);
    }
}
