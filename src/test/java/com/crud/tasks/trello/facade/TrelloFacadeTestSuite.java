package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloFacadeTestSuite {
    @InjectMocks
    private TrelloFacade trelloFacade;
    @Mock
    private TrelloService trelloService;
    @Mock
    private TrelloMapper trelloMapper;
    @Mock
    private TrelloValidator trelloValidator;

    private List<TrelloBoardDto> trelloBoardDtos;
    private List<TrelloBoard> trelloBoards;
    private List<TrelloListDto> trelloListDto;
    private List<TrelloList> trelloList;


    @Before
    public void init(){
        trelloBoardDtos = new ArrayList<>();
        trelloBoards = new ArrayList<>();
        trelloListDto = new ArrayList<>();
        trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "testList", false));
        trelloListDto.add(new TrelloListDto("1", "testList", false));
        trelloBoardDtos.add(new TrelloBoardDto("1", "test", trelloListDto));
        trelloBoards.add(new TrelloBoard("1", "test", trelloList));
    }

    @Test
    public void fetchTrelloBoard() {
        //given
        when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoardDtos);
        when(trelloMapper.mapToBoard(trelloBoardDtos)).thenReturn(trelloBoards);
        when(trelloMapper.mapToBoardDto(anyList())).thenReturn(new ArrayList());
        when(trelloValidator.validateTrelloBoards(trelloBoards)).thenReturn(new ArrayList<>());
        //when
        List<TrelloBoardDto> testList = trelloFacade.fetchTrelloBoard();
        //then
        assertNotNull(testList);
        assertEquals(0, testList.size());

    }

    @Test
    public void fetchTrelloBoardHappyPath(){
        //given
        when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoardDtos);
        when(trelloMapper.mapToBoard(trelloBoardDtos)).thenReturn(trelloBoards);
        when(trelloMapper.mapToBoardDto(anyList())).thenReturn(trelloBoardDtos);
        when(trelloValidator.validateTrelloBoards(trelloBoards)).thenReturn(trelloBoards);
        //when
        List<TrelloBoardDto> testList = trelloFacade.fetchTrelloBoard();
        //then
        assertNotNull(testList);
        assertEquals(1, testList.size());
        testList.forEach(trelloBoardDto -> {
            assertEquals("1", trelloBoardDto.getId());
            assertEquals("test", trelloBoardDto.getName());
            trelloBoardDto.getLists().forEach(trelloListD ->{
                assertEquals("1", trelloListD.getId());
                assertEquals("testList", trelloListD.getName());
                assertEquals(false, trelloListD.isClosed());
            });
        });

    }

    @Test
    public void createCard() {
    }
}