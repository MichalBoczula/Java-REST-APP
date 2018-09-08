package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {
    public Task mapToTask(final TaskDto taskDto){
        return taskDto != null ?
                new Task(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getContent())
                : new Task(
                        000L,
                        "",
                        ""
                );
    }

    public TaskDto mapToTaskDto(final Task task){
        return task != null ?
                new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getContent())
                : new TaskDto(
                        000L,
                        "",
                        ""
        );
    }

    public List<TaskDto> mapToTaskDtoList(final List<Task> taskList){
        return taskList != null ?
                taskList.stream()
                        .map(task -> new TaskDto(task.getId(), task.getTitle(), task.getContent()))
                        .collect(Collectors.toList())
                : new ArrayList<>();
    }
}
