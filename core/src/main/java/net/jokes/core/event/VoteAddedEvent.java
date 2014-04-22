package net.jokes.core.event;

import lombok.*;

@ToString
@AllArgsConstructor
@Getter
@Deprecated
public class VoteAddedEvent implements Event {
    private String userName;

    private String text;
}
