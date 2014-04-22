package net.jokes.core.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import net.jokes.core.domain.VoteValue;

@ToString
@AllArgsConstructor
@Getter
public class VoteAddedEventV2 implements Event {
    private String userName;

    private String text;

    private VoteValue value;
}
