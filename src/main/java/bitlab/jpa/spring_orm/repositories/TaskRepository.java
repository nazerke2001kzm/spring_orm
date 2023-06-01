package bitlab.jpa.spring_orm.repositories;

import bitlab.jpa.spring_orm.models.Folder;
import bitlab.jpa.spring_orm.models.Task;
import groovy.transform.WithReadLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("SELECT u FROM Task u WHERE u.folder.id = :id")
    List<Task> findTasksByFolderId (Long id);


}
