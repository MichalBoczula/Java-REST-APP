package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TaskMapper taskMapper;
    @MockBean
    private DbService dbService;

    @Test
    public void getTasks() throws Exception {
        //given
        final List<Task> tasks = new ArrayList<>();
        final List<TaskDto> tasksDto = new ArrayList<>();
        tasks.add(new Task((long) 1, "test", "test"));
        tasksDto.add(new TaskDto((long) 1, "test", "test"));
        //when
        when(dbService.getAllTasks()).thenReturn(tasks);
        when(taskMapper.mapToTaskDtoList(tasks)).thenReturn(tasksDto);
        //then
        mockMvc.perform(get("/v1/tasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("test")))
                .andExpect(jsonPath("$[0].content", is("test")));
    }

    @Test
    public void getTasksWithNull() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(get("/v1/tasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getTask() throws Exception {
        //given
        final Task task = new Task((long) 1, "test", "test");
        final TaskDto taskDto = new TaskDto((long) 1, "test", "test");
        //when
        when(dbService.findTaskById((long) 1)).thenReturn(java.util.Optional.ofNullable(task));
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //then
        mockMvc.perform(get("/v1/tasks/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("test")))
                .andExpect(jsonPath("$.content", is("test")));
    }

    @Test
    public void getTaskWithNull() throws Exception {
        //given
        final Task task = new Task((long) 1, "test", "test");
        final TaskDto taskDto = null;
        //when
        when(dbService.findTaskById((long) 1)).thenReturn(java.util.Optional.ofNullable(task));
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //then
        mockMvc.perform(get("/v1/tasks/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }


    @Test
    public void deleteTask() throws Exception {
        //given
        final Task task = new Task((long) 1, "test", "test");
        //when
        when(dbService.findTaskById((long) 1)).thenReturn(java.util.Optional.ofNullable(task));
        //then
        mockMvc.perform(delete("/v1/tasks/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    public void updateTask() throws Exception {
        //given
        final Task task = new Task(1L, "test", "test");
        final TaskDto taskDto = new TaskDto(1L, "test", "test");
        final Gson gson = new Gson();
        final String jsonContent = gson.toJson(taskDto);
        //when
        when(dbService.saveTask(task)).thenReturn(task);
        when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //then
        mockMvc.perform(put("/v1/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(jsonContent))
                .andExpect(status().is(200));
    }

    @Test
    public void createTask() throws Exception {
        //given
        final TaskDto taskDto = new TaskDto(1L, "test", "test");
        final Task task = new Task(1L, "test", "test");
        final Gson gson = new Gson();
        final String jsonContent = gson.toJson(taskDto);
        //when
        when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        when(dbService.saveTask(task)).thenReturn(task);
        //then
        mockMvc.perform(post("/v1/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(jsonContent))
                .andExpect(status().is(200));
    }
}