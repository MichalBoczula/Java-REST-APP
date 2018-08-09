package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @Autowired
    private DbService dbService;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks(){
        return taskMapper.mapToTaskDtoList(dbService.getAllTasks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOneTask")
    public TaskDto getOneTask(@RequestParam Long taskId) throws TaskNotFoundException {
        return taskMapper.mapToTaskDto(dbService.findTaskById(taskId).orElseThrow(TaskNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOneTask")
    public void deleteTask(@RequestParam Long taskId) throws DeleteTaskException{
        dbService.deleteTask(dbService.findTaskById(taskId).orElseThrow(DeleteTaskException::new));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOneTask")
    public TaskDto updateTask(@RequestBody  TaskDto task){
        return taskMapper.mapToTaskDto(dbService.saveTask(taskMapper.mapToTask(task)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOneTask")
    public void createTask(@RequestBody TaskDto task){
        dbService.saveTask(taskMapper.mapToTask(task));
    }
}
