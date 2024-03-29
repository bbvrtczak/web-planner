package BB.WebPlanner.controller.api;

import BB.WebPlanner.dto.GetTasksResponse;
import BB.WebPlanner.dto.PutTaskRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface TaskController {
    /**
     * @return list of tasks
     */
    @GetMapping("api/tasks")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetTasksResponse getTasks();

    /**
     * Create task
     */
    @PutMapping("/api/tasks/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putTask(
            @PathVariable("id")
            long id,
            @RequestBody
            PutTaskRequest request
    );
}
