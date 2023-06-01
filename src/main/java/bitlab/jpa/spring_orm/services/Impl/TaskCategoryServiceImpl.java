package bitlab.jpa.spring_orm.services.Impl;

import bitlab.jpa.spring_orm.models.TaskCategory;
import bitlab.jpa.spring_orm.repositories.TaskCategoryRepository;
import bitlab.jpa.spring_orm.services.TaskcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoryServiceImpl implements TaskcategoryService {
    @Autowired
    TaskCategoryRepository taskCategoryRepository;
    @Override
    public TaskCategory findById(Long id) {
        return taskCategoryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<TaskCategory> findAll() {
        return taskCategoryRepository.findAll();
    }

    @Override
    public void save(TaskCategory taskCategory) {
        taskCategoryRepository.save(taskCategory);
    }

    @Override
    public void deleteCategory(TaskCategory taskCategory) {
        taskCategoryRepository.delete(taskCategory);
    }
}
