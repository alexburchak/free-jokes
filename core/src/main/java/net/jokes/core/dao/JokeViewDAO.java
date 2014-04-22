package net.jokes.core.dao;

import net.jokes.core.view.JokeView;

import java.util.List;

public interface JokeViewDAO extends BaseDAO<String, JokeView> {
    List<JokeView> getTopJokes(int count);
}
