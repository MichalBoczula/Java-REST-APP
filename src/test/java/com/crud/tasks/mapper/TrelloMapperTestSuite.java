package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoard() {
        //given
        final List<TrelloBoardDto> nullTrelloBoards = null;
        final List<TrelloBoardDto> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoardDto("1", "testBoard1", new ArrayList<>()));
        trelloBoards.add(new TrelloBoardDto("2", "testBoard2", new ArrayList<>()));
        trelloBoards.add(new TrelloBoardDto("3", "testBoard3", new ArrayList<>()));
        //when
        List<TrelloBoard> trelloBoardTest = trelloMapper.mapToBoard(trelloBoards);
        List<TrelloBoard> nullTrelloBoardTest = trelloMapper.mapToBoard(nullTrelloBoards);
        //then
        assertEquals(0, nullTrelloBoardTest.size());
        assertEquals(trelloBoardTest.size(), trelloBoardTest.size());
        assertEquals(trelloBoardTest.get(0).getName(), trelloBoards.get(0).getName());
        assertEquals(trelloBoardTest.get(1).getName(), trelloBoards.get(1).getName());
        assertEquals(trelloBoardTest.get(2).getName(), trelloBoards.get(2).getName());
        assertEquals(trelloBoardTest.get(0).getId(), trelloBoards.get(0).getId());
        assertEquals(trelloBoardTest.get(1).getId(), trelloBoards.get(1).getId());
        assertEquals(trelloBoardTest.get(2).getId(), trelloBoards.get(2).getId());
        assertEquals(trelloBoardTest.get(0).getLists(), trelloBoards.get(0).getLists());
        assertEquals(trelloBoardTest.get(1).getLists(), trelloBoards.get(1).getLists());
        assertEquals(trelloBoardTest.get(2).getLists(), trelloBoards.get(2).getLists());
    }

    @Test
    public void mapToBoardDto() {
        //given
        final List<TrelloBoard> nullTrelloBoards = null;
        final List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "testBoard1", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("2", "testBoard2", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("3", "testBoard3", new ArrayList<>()));
        //when
        List<TrelloBoardDto> trelloBoardTest = trelloMapper.mapToBoardDto(trelloBoards);
        List<TrelloBoardDto> nullTrelloBoardTest = trelloMapper.mapToBoardDto(nullTrelloBoards);
        //then
        assertEquals(0, nullTrelloBoardTest.size());
        assertEquals(trelloBoardTest.size(), trelloBoards.size());
        assertEquals(trelloBoardTest.get(0).getName(), trelloBoards.get(0).getName());
        assertEquals(trelloBoardTest.get(1).getName(), trelloBoards.get(1).getName());
        assertEquals(trelloBoardTest.get(2).getName(), trelloBoards.get(2).getName());
        assertEquals(trelloBoardTest.get(0).getId(), trelloBoards.get(0).getId());
        assertEquals(trelloBoardTest.get(1).getId(), trelloBoards.get(1).getId());
        assertEquals(trelloBoardTest.get(2).getId(), trelloBoards.get(2).getId());
        assertEquals(trelloBoardTest.get(0).getLists(), trelloBoards.get(0).getLists());
        assertEquals(trelloBoardTest.get(1).getLists(), trelloBoards.get(1).getLists());
        assertEquals(trelloBoardTest.get(2).getLists(), trelloBoards.get(2).getLists());
    }

    @Test
    public void mapToList() {
        //given
        final List<TrelloListDto> trelloListDto = new ArrayList<>();
        final List<TrelloListDto> nullTrelloListDto = null;
        trelloListDto.add(new TrelloListDto("1", "testList1", false));
        trelloListDto.add(new TrelloListDto("2", "testList2", false));
        trelloListDto.add(new TrelloListDto("3", "testList3", false));
        //when
        List<TrelloList> trelloListsTest = trelloMapper.mapToList(trelloListDto);
        List<TrelloList> nullTrelloListsTest = trelloMapper.mapToList(nullTrelloListDto);
        //then
        assertEquals(0, nullTrelloListsTest.size());
        assertEquals(trelloListsTest.size(), trelloListDto.size());
        assertEquals(trelloListsTest.get(0).getName(), trelloListDto.get(0).getName());
        assertEquals(trelloListsTest.get(1).getName(), trelloListDto.get(1).getName());
        assertEquals(trelloListsTest.get(2).getName(), trelloListDto.get(2).getName());
        assertEquals(trelloListsTest.get(0).getId(), trelloListDto.get(0).getId());
        assertEquals(trelloListsTest.get(1).getId(), trelloListDto.get(1).getId());
        assertEquals(trelloListsTest.get(2).getId(), trelloListDto.get(2).getId());
        assertEquals(trelloListsTest.get(0).isClosed(), trelloListDto.get(0).isClosed());
        assertEquals(trelloListsTest.get(1).isClosed(), trelloListDto.get(1).isClosed());
        assertEquals(trelloListsTest.get(2).isClosed(), trelloListDto.get(2).isClosed());
    }

    @Test
    public void mapToListDto() {
        //given
        final List<TrelloList> trelloList = new ArrayList<>();
        final List<TrelloList> nullTrelloList = null;
        trelloList.add(new TrelloList("1", "testList1", false));
        trelloList.add(new TrelloList("2", "testList2", false));
        trelloList.add(new TrelloList("3", "testList3", false));
        //when
        List<TrelloListDto> trelloListsTest = trelloMapper.mapToListDto(trelloList);
        List<TrelloListDto> nullTrelloListsTest = trelloMapper.mapToListDto(nullTrelloList);
        //then
        assertEquals(0, nullTrelloListsTest.size());
        assertEquals(trelloListsTest.size(), trelloList.size());
        assertEquals(trelloListsTest.get(0).getName(), trelloList.get(0).getName());
        assertEquals(trelloListsTest.get(1).getName(), trelloList.get(1).getName());
        assertEquals(trelloListsTest.get(2).getName(), trelloList.get(2).getName());
        assertEquals(trelloListsTest.get(0).getId(), trelloList.get(0).getId());
        assertEquals(trelloListsTest.get(1).getId(), trelloList.get(1).getId());
        assertEquals(trelloListsTest.get(2).getId(), trelloList.get(2).getId());
        assertEquals(trelloListsTest.get(0).isClosed(), trelloList.get(0).isClosed());
        assertEquals(trelloListsTest.get(1).isClosed(), trelloList.get(1).isClosed());
        assertEquals(trelloListsTest.get(2).isClosed(), trelloList.get(2).isClosed());
    }

    @Test
    public void mapToCard() {
        //given
        final TrelloCardDto firstTestCard = new TrelloCardDto("first", "testCard", "1", "1");
        final TrelloCardDto secondTestCard = null;
        //when
        final TrelloCard firstTest = trelloMapper.mapToCard(firstTestCard);
        final TrelloCard secondTest = trelloMapper.mapToCard(secondTestCard);
        //then
        assertEquals(firstTestCard.getName(), firstTest.getName());
        assertEquals(firstTestCard.getDescription(), firstTest.getDescription());
        assertEquals(firstTestCard.getPos(), firstTest.getPos());
        assertEquals(firstTestCard.getListId(), firstTest.getListId());
        assertEquals("", secondTest.getName());
        assertEquals("", secondTest.getDescription());
        assertEquals("", secondTest.getPos());
        assertEquals("", secondTest.getListId());
    }

    @Test
    public void mapToCardDto() {
        //given
        final TrelloCard firstTestCard = new TrelloCard("first", "testCard", "1", "1");
        final TrelloCard secondTestCard = null;
        //when
        final TrelloCardDto firstTest = trelloMapper.mapToCardDto(firstTestCard);
        final TrelloCardDto secondTest = trelloMapper.mapToCardDto(secondTestCard);
        //then
        assertEquals(firstTestCard.getName(), firstTest.getName());
        assertEquals(firstTestCard.getDescription(), firstTest.getDescription());
        assertEquals(firstTestCard.getPos(), firstTest.getPos());
        assertEquals(firstTestCard.getListId(), firstTest.getListId());
        assertEquals("", secondTest.getName());
        assertEquals("", secondTest.getDescription());
        assertEquals("", secondTest.getPos());
        assertEquals("", secondTest.getListId());
    }
}