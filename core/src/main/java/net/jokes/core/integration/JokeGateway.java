package net.jokes.core.integration;

import net.jokes.core.command.AddJokeCommand;
import net.jokes.core.command.AddVoteCommand;

public interface JokeGateway {
    String addJoke(AddJokeCommand command);

    void addVote(AddVoteCommand command);
}
