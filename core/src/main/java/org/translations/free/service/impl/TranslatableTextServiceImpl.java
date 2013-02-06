package org.translations.free.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.translations.free.dao.BaseDAO;
import org.translations.free.dao.TranslatableTextDAO;
import org.translations.free.domain.TranslatableText;

@Service
public class TranslatableTextServiceImpl extends BaseServiceImpl<Long, TranslatableText> {
    @Autowired
    private TranslatableTextDAO translatableTextDAO;

    @Override
    protected BaseDAO<Long, TranslatableText> getDAO()
    {
        return translatableTextDAO;
    }
}
