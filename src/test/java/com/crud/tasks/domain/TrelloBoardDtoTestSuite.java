package com.crud.tasks.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloBoardDtoTestSuite {

    @Test
    public void testClass(){
        //given
        final TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto();
        final TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("1", "test", new ArrayList<>());
        //when & then
        assertEquals(null, trelloBoardDto1.getId());
        assertEquals(null, trelloBoardDto1.getName());
        assertEquals(null, trelloBoardDto1.getLists());
        assertEquals("1", trelloBoardDto2.getId());
        assertEquals("test", trelloBoardDto2.getName());
        assertEquals(0, trelloBoardDto2.getLists().size());
    }
}