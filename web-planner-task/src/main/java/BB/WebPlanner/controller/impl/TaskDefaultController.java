package BB.WebPlanner.controller.impl;

import BB.WebPlanner.controller.api.TaskController;
import BB.WebPlanner.dto.GetTasksResponse;
import BB.WebPlanner.dto.PutTaskRequest;
import BB.WebPlanner.function.RequestToTaskFunction;
import BB.WebPlanner.function.TasksToResponseFunction;
import BB.WebPlanner.service.api.TaskService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    private final RequestToTaskFunction requestToTask;

    @Autowired
    public TaskDefaultController(TaskService service, TasksToResponseFunction tasksToResponse, RequestToTaskFunction requestToTask) {
        this.service = service;
        this.tasksToResponse = tasksToResponse;
        this.requestToTask = requestToTask;
    }

    @Override
    public GetTasksResponse getTasks() {
        return tasksToResponse.apply(service.findAll());
    }

    @Override
    public void putTask(long id, PutTaskRequest request) {
        service.create(requestToTask.apply(id, request));
    }
}
