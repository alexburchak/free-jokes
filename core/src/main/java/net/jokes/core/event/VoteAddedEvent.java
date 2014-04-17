package net.jokes.core.event;

import lombok.*;
import net.jokes.core.domain.VoteValue;

@ToString
@AllArgsConstructor
@Getter
public class VoteAddedEvent implements Event {
    private String userName;

    private String text;

    private VoteValue value;
}
