package BB.WebPlanner.repository;

import BB.WebPlanner.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for task entity. Repositories should be used in business layer (e.g.: in services).
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}