package BB.WebPlanner.service.api;

import BB.WebPlanner.entity.Task;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for all business actions regarding task entity.
 */
public interface TaskService {
    Optional<Task> find(long id);
    List<Task> findAll();
    void create(Task task);
}

