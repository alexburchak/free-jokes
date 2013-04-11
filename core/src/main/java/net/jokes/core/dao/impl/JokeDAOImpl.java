package net.jokes.core.dao.impl;

import net.jokes.core.dao.JokeDAO;
import net.jokes.core.domain.Joke;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("jokeDAO")
public class JokeDAOImpl extends BaseDAOImpl<Long, Joke> implements JokeDAO {
    protected JokeDAOImpl() {
        super(Joke.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Joke> findAll() {
        Query query = getEntityManager().createQuery("FROM Joke ORDER BY created");
        return query.getResultList();
    }
}
