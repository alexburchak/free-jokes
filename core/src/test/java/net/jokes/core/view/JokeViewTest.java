package net.jokes.core.view;

import net.jokes.core.service.JokeViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

@ContextConfiguration(locations = {"classpath:/test-applicationContext.xml"})
public class JokeViewTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private JokeViewService jokeViewService;

    @Test
    public void testGetTopJokes() {
        JokeView worstJokeView = new JokeView(UUID.randomUUID().toString(), "Worst joke ever", -10);
        jokeViewService.save(worstJokeView);

        JokeView goodJokeView = new JokeView(UUID.randomUUID().toString(), "A good joke", 1);
        jokeViewService.save(goodJokeView);

        JokeView bestJokeView = new JokeView(UUID.randomUUID().toString(), "Best joke ever", 500);
        jokeViewService.save(bestJokeView);

        List<JokeView> topJokes = jokeViewService.getTopJokes(10);
        Assert.assertEquals(topJokes.size(), 2);

        Assert.assertEquals(topJokes.get(0), bestJokeView);
        Assert.assertEquals(topJokes.get(1), goodJokeView);
    }
}
