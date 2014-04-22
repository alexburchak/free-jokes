package net.jokes.core.dao.impl;

import net.jokes.core.dao.JokeViewDAO;
import net.jokes.core.view.JokeView;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class JokeViewDAOImpl extends BaseDAOImpl<String, JokeView> implements JokeViewDAO {
    protected JokeViewDAOImpl() {
        super(JokeView.class);
    }

    @Override
    public List<JokeView> getTopJokes(int count) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<JokeView> query = builder.createQuery(JokeView.class);
        Root<JokeView> root = query.from(JokeView.class);

        query.where(builder.gt(root.<Number>get("score"), 0));
        builder.desc(root.get("score"));

        TypedQuery<JokeView> typedQuery = getEntityManager().createQuery(query);
        typedQuery.setMaxResults(count);

        return typedQuery.getResultList();
    }
}
