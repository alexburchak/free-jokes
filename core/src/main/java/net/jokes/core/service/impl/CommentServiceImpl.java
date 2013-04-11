package net.jokes.core.service.impl;

import net.jokes.core.dao.BaseDAO;
import net.jokes.core.dao.CommentDAO;
import net.jokes.core.domain.Comment;
import net.jokes.core.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Long, Comment> implements CommentService {
    @Autowired
    private CommentDAO commentDAO;

    @Override
    protected BaseDAO<Long, Comment> getDAO() {
        return commentDAO;
    }
}
