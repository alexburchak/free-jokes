package net.jokes.core.event;

import lombok.*;

@ToString
@AllArgsConstructor
@Getter
public class JokeAddedEvent implements Event {
    String id;

    String text;
}
