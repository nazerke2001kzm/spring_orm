package bitlab.jpa.spring_orm.services;

import bitlab.jpa.spring_orm.models.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    List<Comment> getByTaskId(Long task_id);
}
