package com.crud.tasks.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttachmentByTypeDtoTestSuite {

    @Test
    public void testClass(){
        //given
        final Trello trello = new Trello();
        final AttachmentByTypeDto attachmentByTypeDto = new AttachmentByTypeDto();
        //when
        attachmentByTypeDto.setTrello(trello);
        trello.setBoard(1);
        trello.setCard(1);
        //then
        assertEquals(trello, attachmentByTypeDto.getTrello());
        assertEquals(1, trello.getBoard());
        assertEquals(1, trello.getCard());
    }
}