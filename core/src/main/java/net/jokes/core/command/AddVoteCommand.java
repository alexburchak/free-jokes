package net.jokes.core.command;

import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Deprecated
public class AddVoteCommand {
    @NotNull
    private String jokeId;

    @NotNull
    private String userName;

    private String text;
}
