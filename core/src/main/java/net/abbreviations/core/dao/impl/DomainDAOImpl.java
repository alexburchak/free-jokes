package net.abbreviations.core.dao.impl;

import net.abbreviations.core.dao.DomainDAO;
import net.abbreviations.core.domain.Domain;
import org.springframework.stereotype.Repository;

@Repository("domainDAO")
public class DomainDAOImpl extends BaseDAOImpl<Long, Domain> implements DomainDAO {
    protected DomainDAOImpl() {
        super(Domain.class);
    }
}
