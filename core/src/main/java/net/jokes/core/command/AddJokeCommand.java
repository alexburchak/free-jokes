package net.jokes.core.command;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddJokeCommand {
    String text;
}
