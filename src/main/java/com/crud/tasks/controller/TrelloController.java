package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
@CrossOrigin("*")
public class TrelloController {
    @Autowired
    private TrelloService trelloService;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloService.fetchTrelloBoards();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createNewCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloService.createTrelloCard(trelloCardDto);
    }

//    @Autowired
//    private TrelloClient trelloClient;
//
//    @RequestMapping(method = RequestMethod.GET, value = "/getTrelloBoards")
//    public List<TrelloBoardDto> getTrelloBoards() {
//        final List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards().stream()
//                .filter(trelloBoardDto -> trelloBoardDto.getId() != null)
//                .filter(trelloBoardDto -> trelloBoardDto.getName().contains("Kodilla"))
//                .collect(Collectors.toList());
//
//        return trelloBoards;
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/createTrelloCard")
//    public CreatedTrelloCard createNewCard(@RequestBody TrelloCardDto trelloCardDto) {
//        return trelloClient.createNewCard(trelloCardDto);
//    }
}