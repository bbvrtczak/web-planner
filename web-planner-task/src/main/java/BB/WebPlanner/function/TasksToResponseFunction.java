package BB.WebPlanner.function;

import BB.WebPlanner.entity.Task;
import BB.WebPlanner.dto.GetTasksResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

/**
 * Coverts {@link List < Task >} to {@link GetTasksResponse}.
 */
@Component
public class TasksToResponseFunction implements Function<List<Task>, GetTasksResponse> {

    @Override
    public GetTasksResponse apply(List<Task> entities) {
        return GetTasksResponse.builder()
                .tasks(entities.stream()
                        .map(task -> GetTasksResponse.Task.builder()
                                .id(task.getId())
                                .name(task.getName())
                                .startDate(task.getStartDate())
                                .endDate(task.getEndDate())
                                .build())
                        .toList())
                .build();
    }
}


