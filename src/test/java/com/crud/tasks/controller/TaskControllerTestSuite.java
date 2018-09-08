package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
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
    @MockBean
    private TaskController taskController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTasks() throws Exception {
        //given
        final List<TaskDto> tasks = new ArrayList<>();
        //when
        tasks.add(new TaskDto((long) 1, "test", "test"));
        when(taskController.getTasks()).thenReturn(tasks);
        //then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
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
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getTask() throws Exception {
        //given
        final TaskDto taskDto = new TaskDto((long) 1, "test", "test");
        //when
        when(taskController.getTask((long) 1)).thenReturn(taskDto);
        //then
        mockMvc.perform(get("/v1/task/getTask?taskId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("test")))
                .andExpect(jsonPath("$.content", is("test")));
    }

    @Test
    public void getTaskWithNull() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(get("/v1/task/getTask?taskId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    public void deleteTask() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(delete("/v1/task/deleteTask?taskId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    public void updateTask() throws Exception {
        //given
        final TaskDto taskDto = new TaskDto(1L, "test", "test");
        final Gson gson = new Gson();
        final String jsonContent = gson.toJson(taskDto);
        //when
        when(taskController.updateTask(taskDto)).thenReturn(taskDto);
        //then
        mockMvc.perform(put("/v1/task/updateTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(jsonContent))
                .andExpect(status().is(200));
    }

    @Test
    public void createTask() throws Exception {
        //given
        final TaskDto taskDto = new TaskDto(1L, "test", "test");
        final Gson gson = new Gson();
        final String jsonContent = gson.toJson(taskDto);
        //when
        when(taskController.updateTask(taskDto)).thenReturn(taskDto);
        //then
        mockMvc.perform(post("/v1/task/createTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(jsonContent))
                .andExpect(status().is(200));
    }
}