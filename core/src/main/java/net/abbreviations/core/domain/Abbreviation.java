package net.abbreviations.core.domain;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "abbreviation", uniqueConstraints = {@UniqueConstraint(name = "abbreviation_text_domain_uk", columnNames = {"abbreviation_text", "domain"})})
public class Abbreviation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 32)
    @NotNull
    private Status status;

    @Column(name = "abbreviation_text", nullable = false, updatable = false)
    @NotNull
    @Size(min = 1)
    private String text;

    @ManyToOne(optional = false)
    @ForeignKey(name = "abbreviation_domain_fk")
    @JoinColumn(name = "domain", nullable = false, updatable = false)
    @NotNull
    private Domain domain;

    @ManyToOne(optional = false)
    @ForeignKey(name = "abbreviation_submitter_fk")
    @JoinColumn(name = "submitter", nullable = false, updatable = false)
    @NotNull
    private User submitter;

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

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
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
