package bitlab.jpa.spring_orm.services.Impl;

import bitlab.jpa.spring_orm.models.Comment;
import bitlab.jpa.spring_orm.repositories.CommentRepository;
import bitlab.jpa.spring_orm.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getByTaskId(Long task_id) {
        List<Comment> comments = commentRepository.findCommentsByTaskId(task_id);
        return comments;
    }
}
