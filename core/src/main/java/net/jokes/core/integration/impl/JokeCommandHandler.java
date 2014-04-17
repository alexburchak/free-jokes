package net.jokes.core.integration.impl;

import lombok.ToString;
import net.jokes.core.command.AddJokeCommand;
import net.jokes.core.command.AddVoteCommand;
import net.jokes.core.domain.Joke;
import net.jokes.core.domain.Vote;
import net.jokes.core.integration.JokeGateway;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.domain.IdentifierFactory;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@ToString
public class JokeCommandHandler implements JokeGateway {
    @Autowired
    @Qualifier("jokeRepository")
    private Repository<Joke> repository;

    @CommandHandler
    @Override
    public String addJoke(AddJokeCommand command) {
        String id = IdentifierFactory.getInstance().generateIdentifier();

        Joke joke = new Joke(id, command.getText());
        repository.add(joke);

        return id;
    }

    @CommandHandler
    @Override
    public void addVote(AddVoteCommand command) {
        Joke joke = repository.load(command.getJokeId());

        Vote vote = new Vote(command.getUserName(), command.getText(), command.getValue());
        joke.addVote(vote);
    }
}
