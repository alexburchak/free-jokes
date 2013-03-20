package net.abbreviations.core.dao.impl;

import net.abbreviations.core.dao.DescriptionDAO;
import net.abbreviations.core.domain.Description;
import org.springframework.stereotype.Repository;

@Repository("translationDAO")
public class DescriptionDAOImpl extends BaseDAOImpl<Long, Description> implements DescriptionDAO {
    protected DescriptionDAOImpl()
    {
        super(Description.class);
    }
}
