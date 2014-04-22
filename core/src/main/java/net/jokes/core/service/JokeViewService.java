package net.jokes.core.service;

import net.jokes.core.view.JokeView;

import java.util.List;

public interface JokeViewService extends BaseService<String, JokeView> {
    List<JokeView> getTopJokes(int count);
}
