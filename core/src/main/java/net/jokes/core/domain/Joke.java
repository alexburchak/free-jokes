package net.jokes.core.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "joke", uniqueConstraints = {@UniqueConstraint(name = "joke_text_uk", columnNames = {"joke_text"})})
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 32)
    @NotNull
    private Status status;

    @Column(name = "joke_text", nullable = false, updatable = false)
    @NotNull
    @Size(min = 1)
    private String text;

    @Column(name = "created", nullable = false, updatable = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    public long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return text;
    }
}
