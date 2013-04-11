package net.jokes.core.domain;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @ManyToOne(optional = false)
    @ForeignKey(name = "comment_joke_fk")
    @JoinColumn(name = "joke", nullable = false, updatable = false)
    @NotNull
    private Joke joke;

    @Column(name = "comment_text", nullable = false, updatable = false)
    @NotNull
    @Size(min = 1)
    private String text;

    @Column(name = "user_name", nullable = false, updatable = false)
    @NotNull
    @Size(min = 1)
    private String userName;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return text;
    }
}
