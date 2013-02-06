package org.translations.free.dao.impl;

import org.springframework.stereotype.Repository;
import org.translations.free.dao.TranslationDAO;
import org.translations.free.domain.Translation;

@Repository("translationDAO")
public class TranslationDAOImpl extends BaseDAOImpl<Long, Translation> implements TranslationDAO {
    protected TranslationDAOImpl()
    {
        super(Translation.class);
    }
}
