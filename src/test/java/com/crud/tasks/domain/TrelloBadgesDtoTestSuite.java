package com.crud.tasks.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloBadgesDtoTestSuite {

    @Test
    public void testClass() {
        //given
        final TrelloBadgesDto trelloBadgesDto = new TrelloBadgesDto();
        final AttachmentByTypeDto attachmentByTypeDto = new AttachmentByTypeDto();
        //when
        trelloBadgesDto.setAttachmentsByType(attachmentByTypeDto);
        trelloBadgesDto.setVotes(1);
        //then
        assertEquals(1, trelloBadgesDto.getVotes());
        assertEquals(attachmentByTypeDto, trelloBadgesDto.getAttachmentsByType());
    }
}