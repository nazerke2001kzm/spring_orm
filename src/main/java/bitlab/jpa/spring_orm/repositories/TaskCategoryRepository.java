package bitlab.jpa.spring_orm.repositories;

import bitlab.jpa.spring_orm.models.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory,Long> {
}
