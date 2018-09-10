package com.crud.tasks.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatedTrelloBadgesTestSuite {

    @Test
    public void test() {
        //given
        final CreatedTrelloBadges createdTrelloBadges= new CreatedTrelloBadges("1", "test", new ArrayList<>());
        //when & Then
        assertEquals("1", createdTrelloBadges.getId());
        assertEquals("test", createdTrelloBadges.getName());
        assertEquals(0, createdTrelloBadges.getBadges().size());
    }

}