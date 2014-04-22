package net.jokes.core.integration;

import net.jokes.core.command.AddJokeCommand;
import net.jokes.core.command.AddVoteCommand;
import net.jokes.core.command.AddVoteCommandEx;

public interface JokeGateway {
    String addJoke(AddJokeCommand command);

    @Deprecated
    void addVote(AddVoteCommand command);

    void addVote(AddVoteCommandEx command);
}
