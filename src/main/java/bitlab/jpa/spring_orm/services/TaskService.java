package bitlab.jpa.spring_orm.services;

import bitlab.jpa.spring_orm.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> findTasksByFolderId(Long folder_id);
    Task findById(Long id);
   void addTask(Task task);
}
