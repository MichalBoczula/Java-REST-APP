package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {
    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    public void testClass(){
         //then
        assertEquals("https://api.trello.com/1", trelloConfig.getTrelloApiEndpoint());
        assertEquals("9869660010069df5c2a7371b1973e9a8", trelloConfig.getTrelloAppKey());
        assertEquals("75d30bf51e8a5e06851e5d6122381163f997824e60391cae08285b6735425694", trelloConfig.getTrelloToken());
        assertEquals("/michaboczula", trelloConfig.getTrelloClient());
    }
}