package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuit {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void mapToTask() {
        //given
        final TaskDto taskDto = new TaskDto((long) 1, "test", "test");
        //when
        final Task testTask = taskMapper.mapToTask(taskDto);
        //then
        assertNotNull(testTask);
        assertEquals(taskDto.getId(), testTask.getId());
        assertEquals(taskDto.getTitle(), testTask.getTitle());
        assertEquals(taskDto.getContent(), testTask.getContent());
    }

    @Test
    public void mapToTaskWithNull() {
        //given
        final TaskDto taskDto = null;
        final long id = 000L;
        //when
        final Task testTask = taskMapper.mapToTask(taskDto);
        //then
        final long testId = testTask.getId();
        assertNotNull(testTask);
        assertEquals(id, testId);
        assertEquals("", testTask.getTitle());
        assertEquals("", testTask.getContent());
    }

    @Test
    public void mapToTaskDto() {
        //given
        final Task task = new Task((long) 1, "test", "test");
        //when
        final TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //then
        assertNotNull(taskDto);
        assertEquals(task.getId(), taskDto.getId());
        assertEquals(task.getTitle(), taskDto.getTitle());
        assertEquals(task.getContent(), taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoWithNull() {
        //given
        final Task task = null;
        final long id = 000L;
        //when
        final TaskDto taskDto = taskMapper.mapToTaskDto(task);
        final long testId = taskDto.getId();
        //then
        assertNotNull(taskDto);
        assertEquals(id, testId);
        assertEquals("", taskDto.getTitle());
        assertEquals("", taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoList() {
        //given
        final List<Task> taskList = new ArrayList<>();
        final Task task1 = new Task((long) 1, "test1", "test1");
        final Task task2 = new Task((long) 2, "test2", "test2");
        taskList.add(task1);
        taskList.add(task2);
        //when
        final List<TaskDto> testList = taskMapper.mapToTaskDtoList(taskList);
        //then
        assertEquals(taskList.size(), testList.size());
        assertEquals(taskList.get(0).getId(), testList.get(0).getId());
        assertEquals(taskList.get(1).getId(), testList.get(1).getId());
        assertEquals(taskList.get(0).getTitle(), testList.get(0).getTitle());
        assertEquals(taskList.get(1).getTitle(), testList.get(1).getTitle());
        assertEquals(taskList.get(0).getContent(), testList.get(0).getContent());
        assertEquals(taskList.get(1).getContent(), testList.get(1).getContent());
    }

    @Test
    public void mapToTaskDtoListWithNull() {
        //given
        final List<Task> taskList = null;
        //when
        final List<TaskDto> testList = taskMapper.mapToTaskDtoList(taskList);
        //then
        assertNotNull(testList);
        assertEquals(0, testList.size());
    }
}