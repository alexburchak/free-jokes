package net.jokes.core.domain;

import net.jokes.core.command.AddJokeCommand;
import net.jokes.core.command.AddVoteCommand;
import net.jokes.core.command.AddVoteCommandEx;
import net.jokes.core.event.Event;
import net.jokes.core.event.JokeAddedEvent;
import net.jokes.core.event.VoteAddedEventV2;
import net.jokes.core.integration.JokeGateway;
import org.axonframework.commandhandling.interceptors.JSR303ViolationException;
import org.axonframework.domain.DomainEventMessage;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.EventVisitor;
import org.axonframework.eventstore.jpa.JpaEventStore;
import org.axonframework.eventstore.management.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(locations = {"classpath:/test-applicationContext.xml"})
public class JokeTest extends AbstractTestNGSpringContextTests {
    @Autowired
    @Qualifier("jokeGateway")
    private JokeGateway gateway;

    @Autowired
    @Qualifier("eventStore")
    private EventStore eventStore;

    @Test
    public void testGatewayAddCommands() {
        AddJokeCommand addJokeCommand = new AddJokeCommand("the funniest joke ever");
        String jokeId = gateway.addJoke(addJokeCommand);

        AddVoteCommand addVoteCommand = new AddVoteCommand(jokeId, "anonymous", "Yeah, it's cool!");
        gateway.addVote(addVoteCommand);

        AddVoteCommandEx addVoteCommandEx = new AddVoteCommandEx(jokeId, "guest", "I agree!", VoteValue.POSITIVE);
        gateway.addVote(addVoteCommandEx);

        JpaEventStore jpaEventStore = (JpaEventStore) eventStore;
        Criteria criteria = jpaEventStore.newCriteriaBuilder().property("aggregateIdentifier").is(jokeId);

        final List<Event> events = new ArrayList<>();

        jpaEventStore.visitEvents(criteria, new EventVisitor() {
            @Override
            public void doWithEvent(DomainEventMessage domainEvent) {
                events.add((Event) domainEvent.getPayload());
            }
        });

        Assert.assertEquals(events.size(), 3);

        Assert.assertTrue(events.get(0) instanceof JokeAddedEvent);
        JokeAddedEvent jokeAddedEvent = (JokeAddedEvent) events.get(0);
        Assert.assertEquals(jokeAddedEvent.getText(), addJokeCommand.getText());

        Assert.assertTrue(events.get(1) instanceof VoteAddedEventV2);
        VoteAddedEventV2 voteAddedEventV2 = (VoteAddedEventV2) events.get(1);
        Assert.assertEquals(voteAddedEventV2.getUserName(), addVoteCommand.getUserName());
        Assert.assertEquals(voteAddedEventV2.getText(), addVoteCommand.getText());
        Assert.assertEquals(voteAddedEventV2.getValue(), VoteValue.INDIFFERENT);

        Assert.assertTrue(events.get(2) instanceof VoteAddedEventV2);
        voteAddedEventV2 = (VoteAddedEventV2) events.get(2);
        Assert.assertEquals(voteAddedEventV2.getUserName(), addVoteCommandEx.getUserName());
        Assert.assertEquals(voteAddedEventV2.getText(), addVoteCommandEx.getText());
        Assert.assertEquals(voteAddedEventV2.getValue(), addVoteCommandEx.getValue());
    }

    @Test
    public void testCommandValidation() {
        AddJokeCommand addJokeCommand = new AddJokeCommand(null);

        try {
            gateway.addJoke(addJokeCommand);
            Assert.fail();
        } catch (JSR303ViolationException e) {
            Assert.assertNotNull(e.getViolations());
            Assert.assertEquals(e.getViolations().size(), 1);

            ConstraintViolation<Object> violation = e.getViolations().iterator().next();
            Assert.assertSame(violation.getRootBeanClass(), AddJokeCommand.class);
            Assert.assertEquals(violation.getPropertyPath().toString(), "text");
            Assert.assertNull(violation.getInvalidValue());
            Assert.assertNotNull(violation.getRootBean());
            Assert.assertTrue(violation.getMessage().contains("null"));
        }
    }
}
