package net.jokes.core.domain;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @ManyToOne(optional = false)
    @ForeignKey(name = "vote_joke_fk")
    @JoinColumn(name = "joke", nullable = false, updatable = false)
    @NotNull
    private Joke joke;

    @Column(name = "value", nullable = false, updatable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private VoteValue value;

    @Column(name = "created", nullable = false, updatable = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    public long getId() {
        return id;
    }

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }

    public VoteValue getValue() {
        return value;
    }

    public void setValue(VoteValue value) {
        this.value = value;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
