package net.abbreviations.core.dao.impl;

import net.abbreviations.core.dao.AbbreviationDAO;
import net.abbreviations.core.domain.Abbreviation;
import org.springframework.stereotype.Repository;

@Repository("translatableTextDAO")
public class AbbreviationDAOImpl extends BaseDAOImpl<Long, Abbreviation> implements AbbreviationDAO {
    protected AbbreviationDAOImpl()
    {
        super(Abbreviation.class);
    }
}
