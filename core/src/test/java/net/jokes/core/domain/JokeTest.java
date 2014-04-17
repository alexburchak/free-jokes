package net.jokes.core.domain;

import net.jokes.core.command.AddJokeCommand;
import net.jokes.core.command.AddVoteCommand;
import net.jokes.core.event.Event;
import net.jokes.core.event.JokeAddedEvent;
import net.jokes.core.event.VoteAddedEvent;
import net.jokes.core.integration.JokeGateway;
import org.axonframework.domain.DomainEventMessage;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.EventVisitor;
import org.axonframework.eventstore.jpa.JpaEventStore;
import org.axonframework.eventstore.management.Criteria;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(locations = {"classpath:/test-applicationContext.xml"})
public class JokeTest extends AbstractTestNGSpringContextTests {
    private long jokeId;

    @Autowired
    @Qualifier("jokeGateway")
    private JokeGateway gateway;

    @Autowired
    @Qualifier("jokeRepository")
    private Repository<Joke> repository;

    @Autowired
    @Qualifier("eventStore")
    private EventStore eventStore;

    @Test
    public void testGatewayAddCommands() {
        AddJokeCommand addJokeCommand = new AddJokeCommand("the funniest joke ever");
        String jokeId = gateway.addJoke(addJokeCommand);

        AddVoteCommand addVoteCommand = new AddVoteCommand(jokeId, "anonymous", "Yeah, it's cool!", VoteValue.POSITIVE);
        gateway.addVote(addVoteCommand);

        JpaEventStore jpaEventStore = (JpaEventStore) eventStore;
        Criteria criteria = jpaEventStore.newCriteriaBuilder().property("aggregateIdentifier").is(jokeId);

        final List<Event> events = new ArrayList<>();

        jpaEventStore.visitEvents(criteria, new EventVisitor() {
            @Override
            public void doWithEvent(DomainEventMessage domainEvent) {
                events.add((Event) domainEvent.getPayload());
            }
        });

        Assert.assertEquals(events.size(), 2);

        Event event = events.get(0);
        Assert.assertTrue(event instanceof JokeAddedEvent);
        Assert.assertEquals(((JokeAddedEvent) event).getText(), addJokeCommand.getText());

        event = events.get(1);
        Assert.assertTrue(event instanceof VoteAddedEvent);
        Assert.assertEquals(((VoteAddedEvent) event).getUserName(), addVoteCommand.getUserName());
        Assert.assertEquals(((VoteAddedEvent) event).getText(), addVoteCommand.getText());
        Assert.assertEquals(((VoteAddedEvent) event).getValue(), addVoteCommand.getValue());
    }
}
