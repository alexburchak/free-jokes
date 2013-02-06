package org.translations.free.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "translation")
public class Translation
{
    private long id;
    private TranslatableText translatableText;
    private String translationText;
    private User submitter;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @ManyToOne(optional = false)
    @ForeignKey(name = "translation_translatable_text_fk")
    @JoinColumn(name = "translatable_text", nullable = false, updatable = false)
    public TranslatableText getTranslatableText()
    {
        return translatableText;
    }

    public void setTranslatableText(TranslatableText translatableText)
    {
        this.translatableText = translatableText;
    }

    @Column(name = "translation_text", nullable = false)
    public String getTranslationText()
    {
        return translationText;
    }

    public void setTranslationText(String translationText)
    {
        this.translationText = translationText;
    }

    @ManyToOne(optional = false)
    @ForeignKey(name = "translation_submitter_fk")
    @JoinColumn(name = "submitter", nullable = false, updatable = false)
    public User getSubmitter()
    {
        return submitter;
    }

    public void setSubmitter(User submitter)
    {
        this.submitter = submitter;
    }

    @Override
    public String toString()
    {
        return translationText;
    }
}
