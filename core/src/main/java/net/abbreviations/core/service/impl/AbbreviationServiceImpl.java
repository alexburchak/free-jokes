package net.abbreviations.core.service.impl;

import net.abbreviations.core.dao.AbbreviationDAO;
import net.abbreviations.core.dao.BaseDAO;
import net.abbreviations.core.domain.Abbreviation;
import net.abbreviations.core.service.AbbreviationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbbreviationServiceImpl extends BaseServiceImpl<Long, Abbreviation> implements AbbreviationService {
    @Autowired
    private AbbreviationDAO abbreviationDAO;

    @Override
    protected BaseDAO<Long, Abbreviation> getDAO() {
        return abbreviationDAO;
    }
}
