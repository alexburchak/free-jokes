package org.translations.free.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.translations.free.dao.BaseDAO;
import org.translations.free.dao.TranslationDAO;
import org.translations.free.domain.Translation;

@Service
public class TranslationServiceImpl extends BaseServiceImpl<Long, Translation> {
    @Autowired
    private TranslationDAO translationDAO;

    @Override
    protected BaseDAO<Long, Translation> getDAO()
    {
        return translationDAO;
    }
}
