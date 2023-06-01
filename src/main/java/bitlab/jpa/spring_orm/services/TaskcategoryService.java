package bitlab.jpa.spring_orm.services;

import bitlab.jpa.spring_orm.models.Task;
import bitlab.jpa.spring_orm.models.TaskCategory;

import java.util.List;

public interface TaskcategoryService {
    TaskCategory findById(Long id);
    List<TaskCategory> findAll();

    void save(TaskCategory taskCategory);
    void deleteCategory(TaskCategory taskCategory);
}
