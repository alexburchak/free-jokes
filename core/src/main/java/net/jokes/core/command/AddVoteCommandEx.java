package net.jokes.core.command;

import lombok.*;
import net.jokes.core.domain.VoteValue;

import javax.validation.constraints.NotNull;

@ToString
@NoArgsConstructor
public class AddVoteCommandEx extends AddVoteCommand {
    @NotNull
    @Getter
    @Setter
    private VoteValue value;

    public AddVoteCommandEx(String jokeId, String userName, String text, VoteValue value) {
        super(jokeId, userName, text);
        this.value = value;
    }
}
