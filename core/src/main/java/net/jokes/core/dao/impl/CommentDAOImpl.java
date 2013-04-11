package net.jokes.core.dao.impl;

import net.jokes.core.dao.CommentDAO;
import net.jokes.core.domain.Comment;
import org.springframework.stereotype.Repository;

@Repository("commentDAO")
public class CommentDAOImpl extends BaseDAOImpl<Long, Comment> implements CommentDAO {
    protected CommentDAOImpl() {
        super(Comment.class);
    }
}
