package net.jokes.core.command;

import lombok.*;
import net.jokes.core.domain.VoteValue;

import javax.validation.constraints.NotNull;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddVoteCommand {
    @NotNull
    private String jokeId;

    @NotNull
    private String userName;

    private String text;

    @NotNull
    private VoteValue value;
}
