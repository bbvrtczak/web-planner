package BB.WebPlanner.service.impl;

import BB.WebPlanner.entity.Task;
import BB.WebPlanner.repository.TaskRepository;
import BB.WebPlanner.service.api.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskDefaultService implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskDefaultService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> find(long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void create(Task task){
        taskRepository.save(task);
    }
}
