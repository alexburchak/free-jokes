package net.abbreviations.core.domain;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "description")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @ManyToOne(optional = false)
    @ForeignKey(name = "description_abbreviation_fk")
    @JoinColumn(name = "abbreviation", nullable = false, updatable = false)
    @NotNull
    private Abbreviation abbreviation;

    @Column(name = "description_text", nullable = false)
    @NotNull
    @Size(min = 1)
    private String text;

    @ManyToOne(optional = false)
    @ForeignKey(name = "description_submitter_fk")
    @JoinColumn(name = "submitter", nullable = false, updatable = false)
    @NotNull
    private User submitter;

    public long getId() {
        return id;
    }

    public Abbreviation getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(Abbreviation abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getSubmitter() {
        return submitter;
    }

    public void setSubmitter(User submitter) {
        this.submitter = submitter;
    }

    @Override
    public String toString() {
        return text;
    }
}
