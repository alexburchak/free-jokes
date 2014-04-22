package net.jokes.core.command;

import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddJokeCommand {
    @NotNull
    String text;
}
