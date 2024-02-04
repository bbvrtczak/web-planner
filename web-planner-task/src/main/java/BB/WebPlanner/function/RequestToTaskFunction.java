package BB.WebPlanner.function;

import BB.WebPlanner.dto.PutTaskRequest;
import BB.WebPlanner.entity.Task;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToTaskFunction
        implements BiFunction<Long, PutTaskRequest, Task> {

    @Override
    public Task apply(Long id, PutTaskRequest request) {
        return Task.builder()
                .id(id)
                .name(request.getName())
                .description(request.getDescription())
                .startDate(request.getStartDateAsLocalDateTime())
                .endDate(request.getEndDateAsLocalDateTime())
                .build();
    }
}

