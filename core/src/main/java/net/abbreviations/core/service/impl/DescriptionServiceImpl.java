package net.abbreviations.core.service.impl;

import net.abbreviations.core.dao.BaseDAO;
import net.abbreviations.core.dao.DescriptionDAO;
import net.abbreviations.core.domain.Description;
import net.abbreviations.core.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescriptionServiceImpl extends BaseServiceImpl<Long, Description> implements DescriptionService {
    @Autowired
    private DescriptionDAO descriptionDAO;

    @Override
    protected BaseDAO<Long, Description> getDAO() {
        return descriptionDAO;
    }
}
