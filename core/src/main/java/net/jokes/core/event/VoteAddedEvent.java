package net.jokes.core.event;

import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@AllArgsConstructor
@Getter
@Deprecated
public class VoteAddedEvent implements Event {
    @NotNull
    private String userName;

    private String text;
}
