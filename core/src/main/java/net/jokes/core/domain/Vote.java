package net.jokes.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class Vote {
    @NotNull
    private String userName;

    private String text;

    @NotNull
    private VoteValue value;
}
