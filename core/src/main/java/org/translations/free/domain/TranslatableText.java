package org.translations.free.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "translatable_text", uniqueConstraints = {@UniqueConstraint(name = "translatable_text_uk", columnNames = {"translatable_text"})})
public class TranslatableText
{
    private long id;
    private TranslationStatus status;
    private String translatableText;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 32)
    public TranslationStatus getStatus()
    {
        return status;
    }

    public void setStatus(TranslationStatus status)
    {
        this.status = status;
    }

    @Column(name = "translatable_text", nullable = false, updatable = false)
    public String getTranslatableText()
    {
        return translatableText;
    }

    public void setTranslatableText(String translatableText)
    {
        this.translatableText = translatableText;
    }

    @Override
    public String toString()
    {
        return translatableText;
    }
}
