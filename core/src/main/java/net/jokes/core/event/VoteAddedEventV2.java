package net.jokes.core.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import net.jokes.core.domain.VoteValue;

import javax.validation.constraints.NotNull;

@ToString
@AllArgsConstructor
@Getter
public class VoteAddedEventV2 implements Event {
    @NotNull
    private String userName;

    private String text;

    @NotNull
    private VoteValue value;
}
