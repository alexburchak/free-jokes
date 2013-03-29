package net.abbreviations.core.service.impl;

import net.abbreviations.core.dao.BaseDAO;
import net.abbreviations.core.dao.DomainDAO;
import net.abbreviations.core.domain.Domain;
import net.abbreviations.core.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainServiceImpl extends BaseServiceImpl<Long, Domain> implements DomainService {
    @Autowired
    private DomainDAO domainDAO;

    @Override
    protected BaseDAO<Long, Domain> getDAO() {
        return domainDAO;
    }
}
