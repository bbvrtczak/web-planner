package BB.WebPlanner.controller.impl;

import BB.WebPlanner.controller.api.TaskController;
import BB.WebPlanner.dto.GetTasksResponse;
import BB.WebPlanner.function.TasksToResponseFunction;
import BB.WebPlanner.service.api.TaskService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log
public class TaskDefaultController implements TaskController {
    /**
     * Service for managing tasks.
     */
    private final TaskService service;

    /**
     * Coverts {@link List <Task>} to {@link GetTasksResponse}.
     */
    private final TasksToResponseFunction tasksToResponse;

    @Autowired
    public TaskDefaultController(TaskService service, TasksToResponseFunction tasksToResponse) {
        this.service = service;
        this.tasksToResponse = tasksToResponse;
    }

    @Override
    public GetTasksResponse getTasks() {
        return tasksToResponse.apply(service.findAll());
    }

}
