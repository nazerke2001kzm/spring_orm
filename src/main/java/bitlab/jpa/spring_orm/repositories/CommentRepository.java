package bitlab.jpa.spring_orm.repositories;
import bitlab.jpa.spring_orm.models.Comment;
import bitlab.jpa.spring_orm.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query("SELECT t FROM Comment t WHERE t.task.id = :task_id")
    List<Comment> findCommentsByTaskId (Long task_id);

}
