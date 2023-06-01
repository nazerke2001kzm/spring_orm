package bitlab.jpa.spring_orm.services.Impl;

import bitlab.jpa.spring_orm.models.Folder;
import bitlab.jpa.spring_orm.models.Task;
import bitlab.jpa.spring_orm.repositories.TaskRepository;
import bitlab.jpa.spring_orm.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import bitlab.jpa.spring_orm.models.Folder;

@Service
public class TaskServiceImpl  implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> findTasksByFolderId(Long folder_id) {

        return taskRepository.findTasksByFolderId(folder_id);
    }
    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }
    public void addTask(Task task){
        taskRepository.save(task);
    }
}
