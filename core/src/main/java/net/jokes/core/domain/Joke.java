package net.jokes.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.jokes.core.event.JokeAddedEvent;
import net.jokes.core.event.VoteAddedEventV2;
import net.jokes.core.event.VoteAddedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
public class Joke extends AbstractAnnotatedAggregateRoot<String> {
    private static final long serialVersionUID = 4822496415698157407L;

    @AggregateIdentifier
    @Getter
    private String id;

    @NotNull
    @Getter
    private String text;

    @Getter
    private List<Vote> votes;

    public Joke(String id, String text) {
        apply(new JokeAddedEvent(id, text));
    }

    public void addVote(String userName, String text) {
        apply(new VoteAddedEvent(userName, text));
    }

    public void addVote(String userName, String text, VoteValue value) {
        apply(new VoteAddedEventV2(userName, text, value));
    }

    @EventHandler
    public void handleJokeAddedEvent(JokeAddedEvent event) {
        this.id = event.getId();
        this.text = event.getText();
        this.votes = new ArrayList<Vote>();
    }

    @EventHandler
    @Deprecated
    public void handleVoteAddedEvent(VoteAddedEvent event) {
        this.votes.add(new Vote(event.getUserName(), event.getText(), VoteValue.INDIFFERENT));
    }

    @EventHandler
    public void handleVoteAddedEventV2(VoteAddedEventV2 event) {
        this.votes.add(new Vote(event.getUserName(), event.getText(), event.getValue()));
    }
}
