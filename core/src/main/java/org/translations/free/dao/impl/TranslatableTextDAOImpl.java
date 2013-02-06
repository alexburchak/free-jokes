package org.translations.free.dao.impl;

import org.springframework.stereotype.Repository;
import org.translations.free.dao.TranslatableTextDAO;
import org.translations.free.domain.TranslatableText;

@Repository("translatableTextDAO")
public class TranslatableTextDAOImpl extends BaseDAOImpl<Long, TranslatableText> implements TranslatableTextDAO {
    protected TranslatableTextDAOImpl()
    {
        super(TranslatableText.class);
    }
}
