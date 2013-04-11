package net.jokes.core.service.impl;

import net.jokes.core.domain.Joke;
import net.jokes.core.domain.Status;
import net.jokes.core.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;

@ContextConfiguration(locations = {"classpath:/test-applicationContext.xml"})
public class JokeServiceTest extends AbstractTestNGSpringContextTests {
    private long jokeId;

    @Autowired
    private JokeService jokeService;

    @BeforeMethod
    public void setUp() {
        Joke joke = new Joke();
        joke.setText("funny hah? " + System.currentTimeMillis());
        joke.setStatus(Status.NEW);
        jokeService.save(joke);
        jokeId = joke.getId();
    }

    /**
     * Tests whether persistence and transactions work
     */
    @Test
    @Transactional
    public void testPersistence() {
        Joke joke = jokeService.findById(jokeId);
        joke.setStatus(Status.APPROVED);
        jokeService.save(joke);
    }

    /**
     * Tests javax.validation applied to domain objects. Requires hibernate v3.5 or above
     */
    @Test
    public void testValidation() {
        try {
            updateJokeStatus(null);
            Assert.fail();
        } catch (Exception e) {
            for (Throwable t = e; ; t = t.getCause()) {
                if (t instanceof ConstraintViolationException)
                    break;
                if (t == null || t.getCause() == t)
                    Assert.fail(ConstraintViolationException.class.getName() + " not found in the stack trace", e);
            }
        }
    }

    /**
     * A separate transaction which updates joke status
     */
    @Transactional
    private void updateJokeStatus(Status status) {
        Joke joke = jokeService.findById(jokeId);
        joke.setStatus(status);
        jokeService.save(joke);
    }
}
